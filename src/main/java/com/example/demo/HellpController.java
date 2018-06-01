package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-5-30 上午9:53
 */
@RestController
public class HellpController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello world";
    }
}
