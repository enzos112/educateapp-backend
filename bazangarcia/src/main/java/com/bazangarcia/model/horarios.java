package com.bazangarcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class horarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int IDhorarios;

    @Column(nullable = false, length = 30)
    private String Dia_semana;

    @Column(nullable = false)
    private LocalTime Hora_inicio;

    @Column(nullable = false)
    private LocalTime Hora_fin;

    @Column(nullable = false, length = 30)
    private String Aula;
}
