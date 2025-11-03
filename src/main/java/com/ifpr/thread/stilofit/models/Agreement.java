package com.ifpr.thread.stilofit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "agreement")
@EqualsAndHashCode(callSuper = true)
public class Agreement extends Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "partners_minimum")
    @NotNull(message = "{validation.partnersMinimum.notnull}")
    @Positive(message = "{validation.partnersMinimum.positive}")
    private Integer partnersMinimum;

}
