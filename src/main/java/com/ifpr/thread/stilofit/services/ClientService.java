package com.ifpr.thread.stilofit.services;

import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.ClientRequestDTO;
import com.ifpr.thread.stilofit.exceptions.CpfAlreadyRegisteredException;
import com.ifpr.thread.stilofit.models.Client;
import com.ifpr.thread.stilofit.repositories.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(ClientRequestDTO clientRequestDTO) {
        if (clientRepository.existsByCpf(clientRequestDTO.getCpf())) {
            throw new CpfAlreadyRegisteredException("CPF já cadastrado");
        }
        Client client = new Client();
        client.setName(clientRequestDTO.getName());
        client.setBirthDate(clientRequestDTO.getBirthDate());
        client.setGender(clientRequestDTO.getGender());
        client.setCpf(clientRequestDTO.getCpf());
        Client clientSave = clientRepository.save(client);
        return clientSave;
    }
}
