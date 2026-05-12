package com.apaproject.servicefinder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String name;
    private String number;
    @NotBlank
    @Column(unique = true)
    private String email;

    private String workerUsername;
    @NotBlank
    private String workerPassword;
    private String profession;


    public Worker(){

    }

    public Worker(String name,String number,String email,String  WorkerUsername,String WorkerPassword,String profession){
this.name=name;
this.number=number;
this.email=email;
this.workerUsername=WorkerUsername;
this.workerPassword=WorkerPassword;
this.profession=profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkerUsername() {
        return workerUsername;
    }

    public void setWorkerUsername(String WorkerUsername) {
        this.workerUsername = WorkerUsername;
    }

    public String getWorkerPassword() {
        return workerPassword;
    }

    public void setWorkerPassword(String WorkerPassword) {
        this.workerPassword = WorkerPassword;
    }

    public void setProfession(String profession){
        this.profession=profession;
    }

     public String getProfession(){
        return profession;
    }
}
