package idgen.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * <p>title:</p>
 * <p>description:用于生成系统序列码</p>
 *
 * @author: yangqc
 * @date Created in 2017-5-11
 */
@Service
@Slf4j
public class SystemSequenceGenerator implements DisposableBean {

  @Value("${file-path}")
  public String FILE_PATH = "";

  public static final String FILE_NAME = "SystemSequenceMapping.properties";

  public static final long SYSTEM_SEQUENCE_MASK = (1 << CommonSelfIdGenerator.SYSTEM_BITS) - 1;

  private static final Map<String, Integer> map;

  static {
    map = new HashMap<>();
    try {
      Properties pro = getProperties();
      Enumeration<?> en = getProperties().propertyNames();
      while (en.hasMoreElements()) {
        String key = (String) en.nextElement();
        int property = Integer.parseInt(pro.get(key).toString());
        map.put(key, property);
      }
    } catch (IOException e) {
      log.error("初始化失败!", e);
    }
  }

  private static Properties getProperties() throws IOException {
    Properties pro = new Properties();
    InputStream in = new ClassPathResource(FILE_NAME).getInputStream();
    pro.load(in);
    return pro;
  }

  /**
   * 根据key获取或者生成系统序列码
   *
   * @param key
   * @return
   */
  public synchronized static int getSequence(String key) {
    Integer result;
    if ((result = map.get(key)) == null) {
      Integer[] keys = map.values().toArray(new Integer[0]);
      Arrays.sort(keys, (x, y) -> y - x);
      result = keys[0];
      if ((++result & SYSTEM_SEQUENCE_MASK) == 0) {
        throw new IllegalArgumentException("超出子系统数量限制范围!");
      }
      map.put(key, ++result);
    }
    return result;
  }

  @Override
  public void destroy() {
    try {
      Properties pro = getProperties();
      File file = new File(FILE_PATH);
      OutputStream fos = new FileOutputStream(file);
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        pro.setProperty(entry.getKey(), String.valueOf(entry.getValue()));
      }
      pro.store(fos, "Update '" + "SystemSequenceMapping" + "' value");
    } catch (IOException e) {
      log.error("文件写入失败!", e);
    }
  }
}
