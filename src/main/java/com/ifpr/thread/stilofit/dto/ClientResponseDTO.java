package com.ifpr.thread.stilofit.dto;


import java.util.Date;

import com.ifpr.thread.stilofit.models.enums.Gender;

import lombok.Data;

@Data
public class ClientResponseDTO {
    private Long id;
    private String name;
    private Date birthDate;
    private Gender gender;
    private String cpf;
}
