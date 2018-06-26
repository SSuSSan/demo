package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping("127.0.0.1/home")
    @ResponseBody
    public String index(@RequestParam(value = "type", defaultValue = "asd") int type){
        return "hello";
    }
}
