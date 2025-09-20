package com.bazangarcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int IDevaluaciones;

    @Column(nullable = false, length = 30)
    private String Tipo_evaluación;

    @Column(nullable = false)
    private LocalDate Fecha;

    @Column(nullable = false)
    private int Nota;
}
