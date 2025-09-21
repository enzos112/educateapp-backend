package com.bazangarcia.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class EstudianteResponseDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private LocalDate fechaIngreso;
}
