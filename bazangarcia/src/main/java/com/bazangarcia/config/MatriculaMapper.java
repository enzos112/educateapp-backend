package com.bazangarcia.config;

import com.bazangarcia.dto.request.MatriculaRequestDto;
import com.bazangarcia.dto.response.MatriculaResponseDto;
import com.bazangarcia.exception.ResourceNotFoundException;
import com.bazangarcia.model.Curso;
import com.bazangarcia.model.Estudiante;
import com.bazangarcia.model.Matricula;
import com.bazangarcia.repository.CursoRepository;
import com.bazangarcia.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Matricula toEntity(MatriculaRequestDto dto) {
        if (dto == null) return null;

        Matricula matricula = new Matricula();
        matricula.setPeriodoAcademico(dto.getPeriodoAcademico());
        matricula.setFechaMatricula(dto.getFechaMatricula());
        matricula.setEstado(true); // Por defecto activa

        // Buscar las entidades relacionadas por ID
        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante", "id", dto.getEstudianteId()));
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso", "id", dto.getCursoId()));

        matricula.setEstudiante(estudiante);
        matricula.setCurso(curso);

        return matricula;
    }

    public MatriculaResponseDto toDto(Matricula matricula) {
        if (matricula == null) return null;

        MatriculaResponseDto response = new MatriculaResponseDto();
        response.setId(matricula.getId());
        response.setPeriodoAcademico(matricula.getPeriodoAcademico());
        response.setFechaMatricula(matricula.getFechaMatricula());
        response.setEstado(matricula.getEstado());
        response.setEstudianteNombre(matricula.getEstudiante().getNombre());
        response.setEstudianteApellido(matricula.getEstudiante().getApellido());
        response.setCursoNombre(matricula.getCurso().getNombre());
        response.setCursoCodigo(matricula.getCurso().getCodigo());

        return response;
    }

}
