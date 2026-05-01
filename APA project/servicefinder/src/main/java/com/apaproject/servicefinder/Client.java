package com.apaproject.servicefinder;

public class Client {
private String ClientName;
private String ClientNumber;
private String ClientEmail;
private String ClientUsername;
private String ClientPassword;

public Client(){

    }

    public Client (String ClientName,String ClientNumber,String ClientEmail,String ClientUsername,String ClientPassword){
this.ClientName=ClientName;
this.ClientNumber=ClientNumber;
this.ClientEmail=ClientEmail;
this.ClientUsername=ClientUsername;
this.ClientPassword=ClientPassword;
    }

    public String getName() {
        return ClientName;
    }

    public void setName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getNumber() {
        return ClientNumber;
    }

    public void setNumber(String ClientNumber) {
        this.ClientNumber = ClientNumber;
    }

    public String getEmail() {
        return ClientEmail;
    }

    public void setEmail(String ClientEmail) {
        this.ClientEmail = ClientEmail;
    }

    public String getUsername() {
        return ClientUsername;
    }

    public void setUsername(String ClientUsername) {
        this.ClientUsername = ClientUsername;
    }

    public String getPassword() {
        return ClientPassword;
    }

    public void setPassword(String ClientPassword) {
        this.ClientPassword = ClientPassword;
    }
}










































