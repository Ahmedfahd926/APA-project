package com.apaproject.servicefinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class usercontroller {

    
    @PostMapping("signup")
    public String signup(@ModelAttribute User user) {
        System.out.print(user.getName());
        return "index.html";
    }
    
    
}
