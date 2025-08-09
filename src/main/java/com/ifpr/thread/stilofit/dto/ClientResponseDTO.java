package com.ifpr.thread.stilofit.dto;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifpr.thread.stilofit.models.enums.Gender;

import lombok.Data;

@Data
public class ClientResponseDTO {
    private Long id;
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private Gender gender;
    private String cpf;
}
