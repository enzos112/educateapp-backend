package com.bazangarcia.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MatriculaRequestDto {
    private String periodoAcademico;
    private LocalDate fechaMatricula;
    private Integer estudianteId;
    private Integer cursoId;
}
