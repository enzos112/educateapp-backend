package com.bazangarcia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String codigo;

    @Column(nullable = false)
    private int Credito;

    @Column (nullable = false, length = 30)
    private String Semestre;

    // Relación con Docente
    @ManyToOne
    @JoinColumn(name = "id_docente", nullable = true)
    private Docente docente;

    // Relación con Matrículas
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Matricula> matriculas;

    // Relación con Horarios
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Horario> horarios;

}
