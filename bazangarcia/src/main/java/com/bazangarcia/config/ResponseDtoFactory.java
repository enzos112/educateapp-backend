package com.bazangarcia.config;
import com.bazangarcia.dto.response.EstudianteResponseDto;
import com.bazangarcia.dto.response.MatriculaResponseDto;
import com.bazangarcia.model.Estudiante;
import com.bazangarcia.model.Matricula;
import org.springframework.stereotype.Component;

@Component
public class ResponseDtoFactory {
    public static final String ESTUDIANTE_TYPE="ESTUDIANTE";
    public static final String MATRICULA_TYPE="MATRICULA";

    public Object createResponseDto(String type, Object entity){
        System.out.println("Factory: Creando DTO de tipo " + type);

        switch (type){
            case ESTUDIANTE_TYPE :
                return createEstudianteDto((Estudiante) entity);
            case MATRICULA_TYPE:
                return createMatriculaDto((Matricula) entity);
            default:
                throw new IllegalArgumentException("Tipo de DTO no soportado: "+type);
        }
    }

    private EstudianteResponseDto createEstudianteDto(Estudiante estudiante) {
        EstudianteResponseDto dto = new EstudianteResponseDto();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setCorreo(estudiante.getCorreo());
        dto.setTelefono(estudiante.getTelefono());
        dto.setFechaIngreso(estudiante.getFechaIngreso());
        return dto;
    }

    private MatriculaResponseDto createMatriculaDto(Matricula matricula) {
        MatriculaResponseDto dto = new MatriculaResponseDto();
        dto.setId(matricula.getId());
        dto.setPeriodoAcademico(matricula.getPeriodoAcademico());
        dto.setFechaMatricula(matricula.getFechaMatricula());
        dto.setEstado(matricula.getEstado());
        return dto;
    }
}
