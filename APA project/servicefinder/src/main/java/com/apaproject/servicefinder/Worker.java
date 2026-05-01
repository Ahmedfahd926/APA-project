package com.apaproject.servicefinder;
public class Worker {
 private String name;
    private String number;
    private String email;
    private String WorkerUsername;
    private String WorkerPassword;


    public Worker(){

    }

    public Worker(String name,String number,String email,String  WorkerUsername,String WorkerPassword){
this.name=name;
this.number=number;
this.email=email;
this.WorkerUsername=WorkerUsername;
this.WorkerPassword=WorkerPassword;
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

    public String getUsername() {
        return WorkerUsername;
    }

    public void setUsername(String WorkerUsername) {
        this.WorkerUsername = WorkerUsername;
    }

    public String getPassword() {
        return WorkerPassword;
    }

    public void setPassword(String WorkerPassword) {
        this.WorkerPassword = WorkerPassword;
    }
}
