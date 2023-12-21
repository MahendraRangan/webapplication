package com.mahi.SpringBootFormHandling.controller;


import com.mahi.SpringBootFormHandling.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model,
                        @RequestParam(value = "message",
                                required = false,
                                defaultValue = "World") String message) {
        model.addAttribute("message", "Hello " + message);
        return "index";
    }
    @RequestMapping("/register")
    public String showForm(Model model) {
        System.out.println("register page");
        User user = new User();
        List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");

        model.addAttribute("user", user);
        model.addAttribute("professionList", professionList);

        return "register_form";
    }
    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user) {

        System.out.println(user);

        return "register_success";
    }
}