package com.csc340.TrailBuddy.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping
    public String homePage(){
        return "login";
    }

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }
}
