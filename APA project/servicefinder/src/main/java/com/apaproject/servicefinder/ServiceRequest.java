package com.apaproject.servicefinder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String governate;
    private String city;
    private String address;
    private String serviceType; 
    private String status = "PENDING"; // Possible: PENDING, ACCEPTED, REJECTED

    // The Client who created the request
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // The Worker who accepts the request (Null until accepted)
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    
   
    public void setGovernate(String governate){
         this.governate = governate;
    }

     public String getGovernate(){
         return governate;
    }
    
    public void setCity(String city){
        this.city=city;
    }


    public String getCity(){
        return city;
    }

     public void setAddress(String address){
         this.address=address;
    }

     public String getAddress(){
         return address;
    }

     public void setServiceType(String serviceType){
         this.serviceType=serviceType;
    }

     public String getServiceType(){
         return serviceType;
    }

     public void setWorker(Worker worker){
         this.worker=worker;
    }

     public Worker getWorker(){
         return worker;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // The Getter for Status (useful for displaying it later)
    public String getStatus() {
        return status;
    }

    // Add this to your ServiceRequest class
public Long getId() {
    return id;
}

// And make sure you have this too!
public void setId(Long id) {
    this.id = id;
}
}
