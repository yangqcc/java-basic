package idgen.generator;

import idgen.config.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author: yangqc
 * @date Created in 2017-5-12
 */
@Component
@Slf4j
public class MachineSequenceGenerator {

  @Autowired
  private ApplicationProperties applicationProperties;

  static final long MACHINE_BITS = 7L;

  static final long MACHINE_ROOM_BITS = 3L;

  private static final long MACHINE_ROOM__LEFT_SHIFT_BITS = MACHINE_BITS;

  public long getMachineSequence() {
    long machineSequence = applicationProperties.getMachineSequence();
    long machineRoomSequence = applicationProperties.getMachineRoomSequence();
    if ((machineSequence & (1 << MACHINE_BITS) - 1) != 0
        && (machineRoomSequence & ((1 << MACHINE_ROOM_BITS) - 1)) != 0) {
      return (machineSequence << MACHINE_ROOM__LEFT_SHIFT_BITS) | machineSequence;
    } else {
      log.error("机器序列超出范围!");
      throw new IllegalArgumentException("超出范围!");
    }
  }
}
