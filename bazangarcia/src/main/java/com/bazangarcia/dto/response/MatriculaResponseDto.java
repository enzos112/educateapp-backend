package com.bazangarcia.dto.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MatriculaResponseDto {
    private Integer id;
    private String periodoAcademico;
    private LocalDate fechaMatricula;
    private Boolean estado;

    // Información básica del estudiante
    private String estudianteNombre;
    private String estudianteApellido;

    // Información básica del curso
    private String cursoNombre;
    private String cursoCodigo;
}
