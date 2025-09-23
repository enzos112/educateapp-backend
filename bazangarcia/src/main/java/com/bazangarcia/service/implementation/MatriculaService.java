package com.bazangarcia.service.implementation;

import com.bazangarcia.exception.ResourceNotFoundException;
import com.bazangarcia.model.Matricula;
import com.bazangarcia.repository.MatriculaRepository;
import com.bazangarcia.service.interfaz.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula findById(Integer id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula", "id", id));
    }

    @Override
    public Matricula save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula update(Integer id, Matricula matricula) {
        Matricula matriculaExiste = matriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula", "id", id));

        // Actualizar campos
        matriculaExiste.setPeriodoAcademico(matricula.getPeriodoAcademico());
        matriculaExiste.setFechaMatricula(matricula.getFechaMatricula());
        matriculaExiste.setEstado(matricula.getEstado());
        matriculaExiste.setEstudiante(matricula.getEstudiante());
        matriculaExiste.setCurso(matricula.getCurso());

        return matriculaRepository.save(matriculaExiste);
    }

    @Override
    public void deleteById(Integer id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula", "id", id));
        matriculaRepository.delete(matricula);
    }

    @Override
    public List<Matricula> findActiveMatriculas() {
        return matriculaRepository.findByEstadoTrue();
    }
}
