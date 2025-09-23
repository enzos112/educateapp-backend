package com.bazangarcia.dto.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MatriculaResponseDto {
    private Integer id;
    private String periodoAcademico;
    private LocalDate fechaMatricula;
    private Boolean estado;

    private String estudianteNombre;
    private String estudianteApellido;

    private String cursoNombre;
    private String cursoCodigo;
}
