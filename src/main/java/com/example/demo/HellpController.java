package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-5-30 上午9:53
 */
@Controller
public class HellpController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map){
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

    @RequestMapping("/login2")
    public String login() {
        return "login";
    }

}
