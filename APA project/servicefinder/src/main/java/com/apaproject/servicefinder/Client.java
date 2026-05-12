package com.apaproject.servicefinder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


// Client.java
@Entity
@Table(name="Clients")
public class Client {

    @NotBlank
    @Size(min=3, max=15)
    private String clientName; // Changed to lowercase 'c'

    @NotBlank
    @Size(min=11, max=11)
    private String clientNumber; // Changed to lowercase 'c'

    @NotBlank
    @Size(max=40)
    @Column(unique = true)
    private String clientEmail; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @NotBlank
    @Size(min=3, max=20)
    @Column(unique = true)
    private String clientUsername; 

    @NotBlank
    @Size(min=6, max=15)
    private String clientPassword; 

    // Update your Getters and Setters to match these names
    
    // ... update other getters/setters similarly

public Client(){

    }

    public Client (String ClientName,String ClientNumber,String ClientEmail,String ClientUsername,String ClientPassword){
this.clientName=ClientName;
this.clientNumber=ClientNumber;
this.clientEmail=ClientEmail;
this.clientUsername=ClientUsername;
this.clientPassword=ClientPassword;
    }

   // ... fields stay the same ...

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }
}
























