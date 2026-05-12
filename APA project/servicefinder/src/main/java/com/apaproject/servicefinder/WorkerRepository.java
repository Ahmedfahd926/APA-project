package com.apaproject.servicefinder;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> findByEmail(String email);
    

    Optional<Worker> findByWorkerUsername(String workerUsername);
    
}