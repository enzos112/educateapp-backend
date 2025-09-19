package com.bazangarcia.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class docentes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int IDdocentes;

    @Column(nullable = false, length= 40)
    private  String Nombre;

    @Column(nullable = false, length = 40)
    private String Apellido;

    @Column(nullable = false, length = 8)
    private int DNI;

    @Column(nullable = false, length = 30)
    private String Correo;

    @Column(nullable = false, length = 9)
    private int Telefono;

    @Column(nullable = false, length = 40)
    private String Especialidad;

    private boolean Estado;
}
