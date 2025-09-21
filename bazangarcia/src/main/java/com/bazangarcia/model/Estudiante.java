    package com.bazangarcia.model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.NoArgsConstructor;

    import java.time.LocalDate;
    import java.util.List;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Entity
    @Table(name = "estudiantes")
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public class Estudiante{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private Integer id;

        @Column(nullable = false, length = 40)
        private String nombre;

        @Column(nullable = false, length = 40)
        private String apellido;

        @Column(nullable = false, length = 8, unique = true)
        private String dni;

        @Column(nullable = false, length = 50, unique = true)
        private String correo;

        @Column(nullable = false, length = 15)
        private String telefono;

        @Column(nullable = false, length = 80)
        private String direccion;

        @Column(nullable = false)
        private LocalDate fechaNacimiento;

        @Column(nullable = false)
        private LocalDate fechaIngreso;

        @Column(nullable = false)
        private Boolean estado = true;

        // Relación con Matrículas
        @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Matricula> matriculas;

    }
