package idgen.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>title:web请求通用处理</p>
 * <p>description:web请求通用处理</p>
 *
 * @author: yubj
 * @date Created in 2017-5-19
 */
@Configuration
@Slf4j
@AllArgsConstructor
public class WebConfigurer {

  private final ApplicationProperties applicationProperties;

  /**
   * 跨域访问设置
   */
  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = applicationProperties.getCors();
    if (config.getAllowedOrigins() != null && !config.getAllowedOrigins().isEmpty()) {
      log.debug("注册跨域过滤器");
      source.registerCorsConfiguration("/**", config);
    }
    return new CorsFilter(source);
  }
}
