package cc.rcbb.design.partterns.decorator.spring.controller;

import cc.rcbb.design.partterns.decorator.spring.config.TimestampRequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * TestController
 * </p>
 *
 * @author rcbb.cc
 * @date 2025/6/13
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public Map<String, Object> test(@RequestBody Map<String, Object> params) {
        return params;
    }

    @RequestMapping("/test1")
    public Map<String, Object> test1(@TimestampRequestBody Map<String, Object> params) {
        return params;
    }


}
