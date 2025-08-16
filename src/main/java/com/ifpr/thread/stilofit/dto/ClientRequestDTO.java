package com.ifpr.thread.stilofit.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifpr.thread.stilofit.models.enums.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRequestDTO {
    @NotBlank(message = "{validation.name.notblank}")
    private String name;
    @NotNull(message = "{validation.birth.notblank}")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    @NotNull(message = "{validation.gender.notblank}")
    private Gender gender;
    @NotBlank(message = "{validation.cpf.notblank}")
    @Size(max = 14)
    @CPF(message = "{validation.cpf.valid}")
    private String cpf;
    @Email
    private String email;
    private String rg;
    private MaritalStatus maritalStatus;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate medicalExamDueDate;
    private Status status = Status.NO_CONTRACT;
    private String responsibleName;
    @Size(max = 14)
    @CPF(message = "{validation.cpf.valid}")
    private String responsibleCpf;
    private String responsiblePhone;
    private String emergencieName;
    private String emergenciePhone;
    private String emergencieObs;
    @Email
    private String contactEmail;
    private String contactPhone;
    private Residence residenceType;
    private String cep;
    private String address;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String addObs;
    private String consultant;
}
