package com.ifpr.thread.stilofit;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ifpr.thread.stilofit.dto.ClientRequestDTO;
import com.ifpr.thread.stilofit.exceptions.CpfAlreadyRegisteredException;
import com.ifpr.thread.stilofit.exceptions.NotBlankException;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.models.Client;
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
        clientRequestDTO.setName("João da Silva");
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
        clientRequestDTO.setName("João da Silva");
        clientRequestDTO.setBirthDate(null);
        assertThrows(NotBlankException.class, () -> clientService.create(clientRequestDTO));
    }

    @Test
    void create_shouldThrowExceptionWhenGenderIsNull() {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        clientRequestDTO.setName("João da Silva");
        clientRequestDTO.setBirthDate(LocalDate.of(2000, 1, 1));
        clientRequestDTO.setGender(null);
        assertThrows(NotBlankException.class, () -> clientService.create(clientRequestDTO));
    }

    @Test
    void findById_shouldReturnClient() {
        Long id = 1L;
        Client client = new Client();
        client.setId(id);
        client.setName("João da Silva");
        when(clientRepository.findById(id)).thenReturn(Optional.of(client));
        Client foundClient = clientService.findById(id);
        assertNotNull(foundClient);
        assertEquals(id, foundClient.getId());
        verify(clientRepository, times(1)).findById(id);
    }

    @Test
    void findById_shouldThrowNotFoundException() {
        Long id = 99L;
        when(clientRepository.findById(id)).thenReturn(Optional.empty());
        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> clientService.findById(id),
                "A exceção NotFoundException deveria ter sido lançada"
        );
        assertTrue(thrown.getMessage().contains("Cliente não encontrado"));
        verify(clientRepository, times(1)).findById(id);
    }
}
