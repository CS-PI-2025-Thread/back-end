package com.ifpr.thread.stilofit.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AgreementRequestDTO extends DiscountRequestDTO {
    @NotNull(message = "{validation.partnersMinimum.notnull}")
    @Positive(message = "{validation.partnersMinimum.positive}")
    private Integer partnersMinimum;
}