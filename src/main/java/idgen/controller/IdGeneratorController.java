package idgen.controller;

import idgen.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author: yangqc
 * @date Created in 2017-5-4
 */
@RestController
@Slf4j
public class IdGeneratorController {

  @Autowired
  private IdGenerator idGenerator;

  @Autowired
  private EurekaRegistration registration;

  @GetMapping("/getId/{key}")
  public String getId(@PathVariable String key) {
    log.debug(registration.getServiceId() + "==" + registration.getNonSecurePort());
    return idGenerator.generateId(key).toString();
  }
}
