package com.ifpr.thread.stilofit.dto;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.ifpr.thread.stilofit.models.enums.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequestDTO {
    @NotBlank(message = "{validation.name.notblank}")
    private String name;
    @NotBlank(message = "{validation.birth.notblank}")
    private Date birthDate;
    @NotBlank(message = "{validation.gender.notblank}")
    private Gender gender;
    @NotBlank(message = "{validation.cpf.notblank}")
    @Size(min = 11, max = 11, message = "{validation.cpf.length}")
    @CPF
    private String cpf;
}
