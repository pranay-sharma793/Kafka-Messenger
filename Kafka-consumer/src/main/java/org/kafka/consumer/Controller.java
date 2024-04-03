package org.kafka.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private List<String> messages = new ArrayList<>();



    @PostMapping("/postMessage")
    public RedirectView postMessage(@RequestParam String message) {
        messages.add(message);
        return new RedirectView("/home", true);
    }

    // Method to handle GET request for /home
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("messages", messages);
        return "home";
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.groupId.name}")
    public RedirectView consume(String data){
        messages.add(data);
        return new RedirectView("/home", true);

    }
}
