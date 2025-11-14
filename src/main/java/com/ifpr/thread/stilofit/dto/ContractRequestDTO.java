package com.ifpr.thread.stilofit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ContractRequestDTO {
    @NotBlank(message = "{validation.name.notblank}")
    private String name;

    @NotBlank(message = "{validation.status.notnull}")
    private String status;

    @NotBlank(message = "{validation.template.notblank}")
    private String template;

    @NotBlank(message = "{validation.installmentable.notblank}")
    private String installmentable;

    private Integer installments;

    @NotNull(message = "{validation.total_value.notnull}")
    private Double totalValue;

    private Double installmentsValue;

    @NotNull(message = "{validation.expire.notnull}")
    private Integer expire;

    @NotBlank(message = "{validation.type_expire.notnull}")
    private String typeExpire;

    private List<String> classRoms;
    private String timeMin;
    private String timeMax;
    private List<String> weekdays;
}