package com.bazangarcia.config;

import com.bazangarcia.dto.response.EstudianteResponseDto;
import com.bazangarcia.dto.response.MatriculaResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ResponseDecorator {

    public EstudianteResponseDto decorateEstudianteResponse(EstudianteResponseDto dto) {
        System.out.println("Decorator: Agregando metadatos a respuesta de Estudiante");

        // Simular agregar metadatos o funcionalidades
        System.out.println("Decorator: Validando datos de estudiante ID: " + dto.getId());
        System.out.println("Decorator: Aplicando reglas de seguridad");

        return dto;
    }

    public MatriculaResponseDto decorateMatriculaResponse(MatriculaResponseDto dto) {
        System.out.println("Decorator: Agregando metadatos a respuesta de Matrícula");
        System.out.println("Decorator: Validando matrícula ID: " + dto.getId());

        return dto;
    }

    public void logResponseCreation(String entityType, Integer entityId) {
        System.out.println("Decorator: Logging creación de " + entityType + " con ID: " + entityId);
    }
}