package com.apaproject.servicefinder;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class WorkerController {

    private final WorkerService workerService;
    private final ServiceRequestRepository serviceRequestRepository;

    public WorkerController(WorkerService workerService,ServiceRequestRepository serviceRequestRepository) {
        this.workerService = workerService;
        this.serviceRequestRepository = serviceRequestRepository;
    }




@GetMapping("/TotalEarnings")
public String showTotalEarnings(HttpSession session, Model model) {
    Worker worker = (Worker) session.getAttribute("loggedInWorker");
    if (worker == null) return "redirect:/worker/login";

    // Count how many jobs this worker has finished
    List<ServiceRequest> completedJobs = serviceRequestRepository
            .findByWorkerAndStatus(worker, "COMPLETED");

    int totalEarnings = completedJobs.size() * 200; // Each job = 200 EGP

    model.addAttribute("worker", worker);
    model.addAttribute("total", totalEarnings);
    model.addAttribute("jobCount", completedJobs.size());
    
    return "TotalEarnings";
}



            //b3d ma tdoos el anchor zorar el worker 
    @GetMapping("/worker/login")
public String showWorkerlogin() {
    return "workerlogin"; 
}





@GetMapping("/WorkerHome")
public String ShowWorkerHome(HttpSession session, Model model) {
    Worker worker = (Worker) session.getAttribute("loggedInWorker");
    
    if (worker == null) return "redirect:/worker/login"; // Security!

    List<ServiceRequest> jobs = serviceRequestRepository
            .findByServiceTypeAndStatus(worker.getProfession(), "PENDING");

    model.addAttribute("jobs", jobs);
    model.addAttribute("worker", worker);
    return "WorkerHomePage";
}




                //login el worker
 @PostMapping("/worker/login")
public String workerLogin(@ModelAttribute Worker worker, Model model, HttpSession session) {
    
    Worker authenticated = workerService.login(worker.getWorkerUsername(), worker.getWorkerPassword());
    
    if (authenticated != null) {
        
        session.setAttribute("loggedInWorker", authenticated);
        
        // 3. FETCH DATA: Get only the jobs that match this worker's profession
        // This is what fills your table!
        List<ServiceRequest> availableJobs = serviceRequestRepository
            .findByServiceTypeAndStatus(authenticated.getProfession(), "PENDING");

        // 4. PACK THE BACKPACK: Send the jobs and worker info to the HTML
        model.addAttribute("jobs", availableJobs);
        model.addAttribute("worker", authenticated);
        
        return "WorkerHomePage"; 
    } else {
    
        model.addAttribute("errorMessage", "Wrong Username or password");
        return "workerlogin"; 
    }
}


@PostMapping("/worker/complete-job/{id}")
public String completeJob(@PathVariable Long id, HttpSession session) {
    Worker worker = (Worker) session.getAttribute("loggedInWorker");
    if (worker == null) return "redirect:/worker/login";

    ServiceRequest job = serviceRequestRepository.findById(id).orElse(null);
    if (job != null) {
        job.setWorker(worker);
        job.setStatus("COMPLETED"); // Change status to COMPLETED
        serviceRequestRepository.save(job);
    }

    return "redirect:/TotalEarnings"; 
}
}