package com.ifpr.thread.stilofit.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifpr.thread.stilofit.models.enums.*;
import lombok.Data;

@Data
public class ClientResponseDTO {
    private Long id;
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private Gender gender;
    private String cpf;
    private String email;
    private String rg;
    private MaritalStatus maritalStatus;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate medicalExamDueDate;
    private Status status;
    private String responsibleName;
    private String responsibleCpf;
    private String responsiblePhone;
    private String emergencieName;
    private String emergenciePhone;
    private String emergencieObs;
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
