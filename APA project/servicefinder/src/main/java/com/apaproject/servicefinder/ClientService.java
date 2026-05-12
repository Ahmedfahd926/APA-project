package com.apaproject.servicefinder;


import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client signup(Client client){
        if(clientRepository.findByClientEmail(client.getClientEmail()).isPresent()){
            return null;
        }
        return clientRepository.save(client);
    }

    
    public Client login(String username, String password) {
    return clientRepository.findByClientUsername(username) 
            .filter(c -> c.getClientPassword().equals(password))
            .orElse(null);
}
}