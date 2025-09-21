package com.bazangarcia.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteRequestDto {
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
}
