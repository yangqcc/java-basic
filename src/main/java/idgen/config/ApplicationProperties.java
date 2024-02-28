package idgen.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author: yangqc
 * @date Created in 2017-5-12
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

  /**
   * cors跨域配置
   */
  @Getter
  private final CorsConfiguration cors = new CorsConfiguration();

  /**
   * 机器号
   */
  @Getter
  @Setter
  private long machineSequence;

  /**
   * 机房号
   */
  @Setter
  @Getter
  private long machineRoomSequence;
}
