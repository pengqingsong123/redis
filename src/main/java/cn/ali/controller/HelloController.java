package cn.ali.controller;

import cn.ali.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("hello")
    public String operaRedis() {
        helloService.opreaRedis();
        return "ok";
    }
}
