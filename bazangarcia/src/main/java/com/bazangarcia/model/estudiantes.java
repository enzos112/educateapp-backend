package com.bazangarcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class estudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int IDestudiantes;

    @Column(nullable = false, length = 40)
    private String Nombre;

    @Column(nullable = false, length = 40)
    private String Apellido;

    @Column(nullable = false, length = 8)
    private int DNI;

    @Column(nullable = false, length = 50)
    private String Correo;

    @Column(nullable = false, length = 9)
    private int Telefono;

    @Column(nullable = false, length = 80)
    private String Direccion;

    @Column(nullable = false)
    private LocalDate F_Nacimiento;

    @Column(nullable = false)
    private LocalDate F_Ingreso;

    private boolean Estado;
}
