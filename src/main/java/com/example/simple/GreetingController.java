package com.example.simple;

import com.example.simple.domain.Message;
import com.example.simple.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World")  String name,
                           Map<String, Object> model)
    {
            model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> map){
        Iterable<Message> messages = messageRepo.findAll();
        map.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String addedd(@RequestParam String name, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(name, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

}
