package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

//    @GetMapping("/")
//    public String home() {
//        // Redirect root URL to the Sign In page
//        return "redirect:/client/login";
//    }



    @GetMapping("/")
    public String showHomePage() {
        return "index"; // Maps to /WEB-INF/views/index.jsp
    }
}
