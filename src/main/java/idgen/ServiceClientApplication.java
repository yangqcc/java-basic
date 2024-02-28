package idgen;

import idgen.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author: yangqc
 * @date Created in 2017-4-26
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties({ApplicationProperties.class})
public class ServiceClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceClientApplication.class, args);
  }

}
