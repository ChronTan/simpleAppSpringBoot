package com.example.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World")  int age,
                           Map<String, Object> model)
    {
        if(age<18){
            model.put("name", "Вход воспрещен");
        }else
            model.put("name", "Go");
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> map){
        map.put("some", "Main page!");
        return "mainPage";
    }

}
