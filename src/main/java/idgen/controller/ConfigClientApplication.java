package idgen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author: yangqc
 * @date Created in 2017-5-15
 */
@RestController
@RefreshScope
public class ConfigClientApplication {

  @Value("${cityos-config}")
  String name = "Hello,World";

  @RequestMapping("/")
  public String home() {
    return name;
  }

}
