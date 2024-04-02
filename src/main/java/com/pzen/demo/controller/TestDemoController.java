package com.pzen.demo.controller;

import com.pzen.demo.common.annotation.RateLimiter;
import com.pzen.demo.common.core.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 测试控制器
 *
 * @author pzen
 */

@RestController
public class TestDemoController extends BaseController {


    @GetMapping("/index")
    @RateLimiter(count = 1, time = 10)
    public String index() {
        return "Hello World!";
    }


}
