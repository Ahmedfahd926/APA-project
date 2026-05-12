package com.apaproject.servicefinder;


import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    
    private final WorkerRepository workerRepository;

    // Constructor injection
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    // Worker Signup Logic
    // Inside WorkerService.java
public Worker signup(Worker worker) {
    // Ensure this matches the repository method name exactly
    if (workerRepository.findByEmail(worker.getEmail()).isPresent()) {
        return null; 
    }
    return workerRepository.save(worker);
}

    
    public Worker login(String username, String password) {
    return workerRepository.findByWorkerUsername(username)
            .filter(w -> w.getWorkerPassword().equals(password))
            .orElse(null);
}
}