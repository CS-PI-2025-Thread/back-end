package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.ClientResponseDTO;
import com.ifpr.thread.stilofit.models.Client;

public class ClientMapper {
    
    public static ClientResponseDTO toResponse(Client client) {
        ClientResponseDTO response = new ClientResponseDTO();
        response.setId(client.getId());
        response.setName(client.getName());
        response.setBirthDate(client.getBirthDate());
        response.setGender(client.getGender());
        response.setCpf(client.getCpf());
        return response;
    }
}
