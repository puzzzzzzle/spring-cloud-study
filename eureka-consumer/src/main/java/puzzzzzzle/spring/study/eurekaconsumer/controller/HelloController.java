package puzzzzzzle.spring.study.eurekaconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        var call = restTemplate.getForEntity("http://hello-server/hello", String.class);
        var ret = call.getBody();
        log.debug("get result from hello {}", ret);
        return String.format("got from hello-server %s", ret);
    }
}
