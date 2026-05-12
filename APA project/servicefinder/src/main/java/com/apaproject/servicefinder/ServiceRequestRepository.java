package com.apaproject.servicefinder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    
    // For Workers to see available jobs in their field
    List<ServiceRequest> findByServiceTypeAndStatus(String serviceType, String status);
    
    // For Clients to see their own history
    List<ServiceRequest> findByClientId(Long clientId);
    List<ServiceRequest> findByWorkerAndStatus(Worker worker, String status);

}
