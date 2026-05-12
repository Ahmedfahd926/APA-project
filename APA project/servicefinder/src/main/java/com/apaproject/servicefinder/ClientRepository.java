package com.apaproject.servicefinder;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Optional<Client> findByClientEmail(String clientEmail);
    Optional<Client> findByClientUsername(String clientUsername);
}
