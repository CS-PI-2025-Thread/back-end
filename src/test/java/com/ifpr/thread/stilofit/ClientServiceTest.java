package com.ifpr.thread.stilofit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ifpr.thread.stilofit.dto.ClientRequestDTO;
import com.ifpr.thread.stilofit.exceptions.CpfAlreadyRegisteredException;
import com.ifpr.thread.stilofit.exceptions.NotBlankException;
import com.ifpr.thread.stilofit.models.enums.Gender;
import com.ifpr.thread.stilofit.repositories.ClientRepository;
import com.ifpr.thread.stilofit.services.ClientService;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void create_shouldThrowExceptionWhenCpfAlreadyExists() {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setName("John Doe");
        clientRequestDTO.setBirthDate(LocalDate.of(2000, 1, 1));
        clientRequestDTO.setGender(Gender.MASCULINO);
        clientRequestDTO.setCpf("123.456.789-00");
        when(clientRepository.existsByCpf("123.456.789-00")).thenReturn(true);
        assertThrows(CpfAlreadyRegisteredException.class, () -> clientService.create(clientRequestDTO));
    }

    @Test
    void create_shouldThrowExceptionWhenNameIsBlank() {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setName(" ");
        assertThrows(NotBlankException.class, () -> clientService.create(clientRequestDTO));
    }

    @Test
    void create_shouldThrowExceptionWhenBirthDateIsNull() {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setName("John Doe");
        clientRequestDTO.setBirthDate(null);
        assertThrows(NotBlankException.class, () -> clientService.create(clientRequestDTO));
    }

    @Test
    void create_shouldThrowExceptionWhenGenderIsNull() {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setName("John Doe");
        clientRequestDTO.setBirthDate(LocalDate.of(2000, 1, 1));
        clientRequestDTO.setGender(null);
        assertThrows(NotBlankException.class, () -> clientService.create(clientRequestDTO));

    }
}
