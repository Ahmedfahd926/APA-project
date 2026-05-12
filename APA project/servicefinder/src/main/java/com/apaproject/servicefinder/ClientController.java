package com.apaproject.servicefinder;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;





@Controller
public class ClientController {
    private final ClientService clientService;
    private final ServiceRequestRepository serviceRequestRepository;

    // Use constructor injection for the service only
    public ClientController(ClientService clientService,ServiceRequestRepository serviceRequestRepository){
        this.clientService = clientService;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    @GetMapping("/")
    public String Showindex() {
        return "index";
    }

    @GetMapping("/signup")
    public String ShowSignup() {
        return "signup";
    }
    
    @GetMapping("/Home")
    public String ShowHomeinclient() {
        return "ClientHomePage";
    }
    
    
        //signup bta3 client
    @PostMapping("/signup")
public String signup(@ModelAttribute Client client, Model model) {

    Client savedClient = clientService.signup(client);
    
    if (savedClient == null) {
        model.addAttribute("error", "Email already registered!");
        return "signup"; 
    }
    
    model.addAttribute("successMessage", "Signup successful! Please login.");
    return "index"; 
}


                //login bta3 el client
@PostMapping("/login")
public String login(@ModelAttribute Client client, Model model,HttpSession session) {
    Client authenticated = clientService.login(client.getClientUsername(), client.getClientPassword());
    
    if (authenticated != null) {
        
        session.setAttribute("loggedInClient", authenticated);
        return "ClientHomePage"; 
    } else {
        
        model.addAttribute("errorMessage", "Wrong Username or password");
        return "index"; 
    }
}
                // lma ydoos submit feil selection
@PostMapping("/book-service")
public String bookService(@ModelAttribute ServiceRequest request, HttpSession session) {
    Client loggedInClient = (Client) session.getAttribute("loggedInClient");
    
    if (loggedInClient == null) return "redirect:/"; 

    request.setClient(loggedInClient);
    request.setStatus("PENDING");
    serviceRequestRepository.save(request);
    
    return "redirect:/Home?success=RequestSent";
}

}



