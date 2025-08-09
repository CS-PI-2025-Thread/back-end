package com.ifpr.thread.stilofit.dto;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.ifpr.thread.stilofit.models.enums.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequestDTO {
    @NotBlank(message = "{validation.name.notblank}")
    private String name;
    @NotNull(message = "{validation.birth.notblank}")
    private Date birthDate;
    @NotNull(message = "{validation.gender.notblank}")
    private Gender gender;
    @NotBlank(message = "{validation.cpf.notblank}")
    @Size(max = 14)
    @CPF
    private String cpf;
}
