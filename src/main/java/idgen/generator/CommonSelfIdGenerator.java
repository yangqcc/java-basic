package idgen.generator;

import com.google.common.base.Preconditions;
import idgen.time.AbstractClock;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>title:自生成Id生成器.</p>
 * <p>description:
 * 长度为64bit,从高位到低位依次为
 * 39bits 时间偏移量从2017年5月1日零点到现在的毫秒数
 * 10bits 工作机器Id
 * 4bits 子系统编码
 * 4bits 预留四位
 * 7bits 同一个毫秒内的自增量
 * </p>
 *
 * @author: yangqc
 * @date Created in 2017-5-4
 */
@Getter
@Slf4j
@Service
public class CommonSelfIdGenerator implements IdGenerator {

  /**
   * 初始时间毫秒数
   */
  static final long SJDBC_EPOCH;

  /**
   * 毫秒内序列号 7 bit
   */
  static final long SEQUENCE_BITS = 7L;

  /**
   * 预留4bit
   */
  static final long RESERVE_BITS = 4L;

  /**
   * 子系统ID位数
   */
  static final long SYSTEM_BITS = 4L;

  /**
   * 工作机器ID (机房 3bit,机器 7bit)
   */
  static final long WORKER_ID_BITS = 10L;

  /**
   * 序列号最大值
   */
  static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;

  /**
   * 子系统编码左移位数
   */
  static final long SYSTEM_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS + RESERVE_BITS;

  /**
   * 工作ID左移位数
   */
  static final long WORKER_ID_LEFT_SHIFT_BITS = SYSTEM_ID_LEFT_SHIFT_BITS + SYSTEM_BITS;

  /**
   * 毫秒数左移位数
   */
  static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;

  /**
   * 工作ID最大值
   */
  private static final long WORKER_ID_MAX_VALUE = 1L << WORKER_ID_BITS;

  @Setter
  private static AbstractClock clock = AbstractClock.systemClock();

  @Getter
  private static long workerId;

  static {
    //初始时间，用于初始化毫秒数
    Calendar calendar = Calendar.getInstance();
    calendar.set(2017, Calendar.MAY, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    SJDBC_EPOCH = calendar.getTimeInMillis();
//        initWorkerId();
  }

  private long sequence;

  private long lastTime;

  @Autowired
  private MachineSequenceGenerator machineSequenceGenerator;

//    /**
//     * 初始化工作ID
//     */
//    static void initWorkerId() {
//        workerId = machineSequenceGenerator.getMachineSequence();
//        setWorkerId(Long.valueOf(workerId));
//    }

  /**
   * 设置工作进程Id.
   *
   * @param workerId 工作进程Id
   */
  public static void setWorkerId(final Long workerId) {
    Preconditions.checkArgument(workerId >= 0L && workerId < WORKER_ID_MAX_VALUE);
    CommonSelfIdGenerator.workerId = workerId;
  }

  /**
   * 生成Id.
   *
   * @return 返回@{@link Long}类型的Id
   */
  @Override
  public synchronized Number generateId(String key) {
    long time = clock.millis();
    //这里处理时钟回拨问题，直接报错
    Preconditions.checkState(lastTime <= time,
        "Clock is moving backwards, last time is %d milliseconds, current time is %d milliseconds",
        lastTime, time);
    //如果当前时间时间等于上一次获取时间
    if (lastTime == time) {
      //如果当前毫秒周期自增序列号已到最大值，等待下一个毫秒周期
      if (0L == (sequence = ++sequence & SEQUENCE_MASK)) {
        time = waitUntilNextTime(time);
      }
    } else {
      sequence = 0;
    }
    lastTime = time;
    if (log.isDebugEnabled()) {
      log.debug("{}-{}-{}",
          new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(lastTime)), workerId,
          sequence);
    }
    return ((time - SJDBC_EPOCH) << TIMESTAMP_LEFT_SHIFT_BITS) | (
        machineSequenceGenerator.getMachineSequence() << WORKER_ID_LEFT_SHIFT_BITS) |
        ((long) SystemSequenceGenerator.getSequence(key) << SYSTEM_ID_LEFT_SHIFT_BITS) | sequence;
  }

  private long waitUntilNextTime(final long lastTime) {
    long time = clock.millis();
    while (time <= lastTime) {
      time = clock.millis();
    }
    return time;
  }
}
