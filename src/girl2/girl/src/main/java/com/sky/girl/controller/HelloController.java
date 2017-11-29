package com.sky.girl.controller;

import com.sky.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
public class HelloController {


    @Value("${girl.cupSize}")
    private String cupSize;
    @Value("${girl.age}")
    private Integer age;
    @Value("${girl.content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;


    @RequestMapping("hello")
    public String say(){
        return content;
    }
    @ResponseBody
    @RequestMapping("hello2")
    public String say2(){
        return girlProperties.toString();
    }
    @RequestMapping("hello3")
    public String say3(){
        return "index";
    }
}
