package com.ifpr.thread.stilofit.models;

import com.ifpr.thread.stilofit.models.enums.Status;

import java.time.LocalDate;

import com.ifpr.thread.stilofit.models.enums.Gender;
import com.ifpr.thread.stilofit.models.enums.MaritalStatus;
import com.ifpr.thread.stilofit.models.enums.Residence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "{validation.name.notblank}")
    private String name;

    @Column(name = "email", unique = true)
    @Email(message = "{validation.email.valid}")
    private String email;

    @Column(name = "birth_date")
    @NotNull(message = "{validation.birth.notblank}")
    private LocalDate birthDate;

    @Column(name = "gender")
    @NotNull(message = "{validation.gender.notblank}")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    @NotBlank(message = "{validation.cpf.notblank}")
    private String cpf;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.SEM_CONTRATO;

    @Column(name = "rg", unique = true,  nullable = true)
    private String rg;

    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "medical_exam_due_date")
    @Temporal(TemporalType.DATE)
    private LocalDate medicalExamDueDate;

    @Column(name = "responsible_name")
    private String responsibleName;

    @Column(name = "responsible_cpf", unique = true, length = 14)
    @Size(min = 14, max = 14, message = "{validation.cpf.length}")
    private String responsibleCpf;

    @Column(name = "responsible_phone")
    private String responsiblePhone;

    @Column(name = "emergencie_name")
    private String emergencieName;

    @Column(name = "emergencie_phone")
    private String emergenciePhone;

    @Column(name = "emergencie_obs", columnDefinition = "TEXT")
    private String emergencieObs;

    @Column(name = "contact_email")
    @Email(message = "{validation.email.valid}")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "residence_type")
    @Enumerated
    private Residence residenceType;

    @Column(name = "cep")
    private String cep;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "add_obs", columnDefinition = "TEXT")
    private String addObs;

    @Column(name = "consultant")
    private String consultant;
}
