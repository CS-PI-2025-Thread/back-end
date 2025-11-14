package com.ifpr.thread.stilofit.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

import com.ifpr.thread.stilofit.models.enums.ContractStatus;
import com.ifpr.thread.stilofit.models.enums.TypeExpire;

@Data
public class ContractRequestDTO {

    @NotBlank(message = "{validation.name.notblank}")
    private String name;

    @NotBlank(message = "{validation.status.notnull}")
    @Enumerated(EnumType.STRING)
    private ContractStatus status;

    @NotBlank(message = "{validation.template.notblank}")
    private String template;

    @NotBlank(message = "{validation.installmentable.notnull}")
    private boolean installmentable;

    private Integer installments;

    @NotNull(message = "{validation.total_value.notnull}")
    private Double totalValue;

    private Double installmentsValue;

    @NotNull(message = "{validation.expire.notnull}")
    private Integer expire;

    @NotBlank(message = "{validation.type_expire.notnull}")
    @Enumerated(EnumType.STRING)
    private TypeExpire typeExpire;

    private List<String> classRoms;
    private String timeMin;
    private String timeMax;
    private List<String> weekdays;
}
