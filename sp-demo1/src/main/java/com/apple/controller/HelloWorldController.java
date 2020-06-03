package com.apple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello chen";
    }

}


//@Controller是标注这是@Controller类
//@ResponseBody是将return的内容给浏览器
//@RequestMapping("/hello")是将路由hello映射到这个方法上