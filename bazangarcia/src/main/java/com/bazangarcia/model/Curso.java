package com.bazangarcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int IDcursos;

    @Column(nullable = false, length = 70)
    private String Nombre;

    @Column(nullable = false, length = 10 )
    private String Codigo;

    @Column(nullable = false)
    private int Credito;

    @Column (nullable = false, length = 30)
    private String Semestre;

}
