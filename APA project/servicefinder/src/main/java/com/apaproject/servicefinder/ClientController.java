package com.apaproject.servicefinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ClientController {
    @PostMapping("/signup")
    public String signup(@ModelAttribute Client client ) {
System.out.println(client.getName());
System.out.println(client.getEmail());
System.out.println(client.getNumber());
System.out.println(client.getUsername());
System.out.println(client.getPassword());
         return "redirect:/signupsuccess.html";
    }
}
