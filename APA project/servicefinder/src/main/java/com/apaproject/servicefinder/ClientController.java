package com.apaproject.servicefinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ClientController {
    @PostMapping("/signup")
    public String signup(@RequestParam("username")String name ) {
System.out.println(name);
         return "redirect:/signupsuccess.html";
    }
    


}
