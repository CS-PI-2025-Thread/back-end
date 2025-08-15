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
        client.setRg(clientRequestDTO.getRg());
        client.setEmail(clientRequestDTO.getEmail());
        client.setMaritalStatus(clientRequestDTO.getMaritalStatus());
        client.setMedicalExamDueDate(clientRequestDTO.getMedicalExamDueDate());
        client.setStatus(clientRequestDTO.getStatus());
        client.setResponsibleName(clientRequestDTO.getResponsibleName());
        client.setResponsibleCpf(clientRequestDTO.getResponsibleCpf());
        client.setResponsiblePhone(clientRequestDTO.getResponsiblePhone());
        client.setEmergencieName(clientRequestDTO.getEmergencieName());
        client.setEmergenciePhone(clientRequestDTO.getEmergenciePhone());
        client.setEmergencieObs(clientRequestDTO.getEmergencieObs());

        client.setContactEmail(clientRequestDTO.getContactEmail());
        client.setContactPhone(clientRequestDTO.getContactPhone());

        client.setResidenceType(clientRequestDTO.getResidenceType());
        client.setCep(clientRequestDTO.getCep());
        client.setAddress(clientRequestDTO.getAddress());
        client.setNumber(clientRequestDTO.getNumber());
        client.setComplement(clientRequestDTO.getComplement());
        client.setNeighborhood(clientRequestDTO.getNeighborhood());
        client.setCity(clientRequestDTO.getCity());
        client.setState(clientRequestDTO.getState());
        client.setAddObs(clientRequestDTO.getAddObs());

        client.setConsultant(clientRequestDTO.getConsultant());
        Client clientSave = clientRepository.save(client);
        return clientSave;
    }
}
