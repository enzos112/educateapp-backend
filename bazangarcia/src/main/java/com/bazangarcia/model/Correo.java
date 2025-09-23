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
@Table(name = "correos")
public class Correo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 20)
    private String remitente;
    @Column(nullable = false, length = 20)
    private String destinatario;
    @Column(nullable = false, length = 50)
    private String asunto;
    @Column(nullable = false, length = 400)
    private String contenido;

}
