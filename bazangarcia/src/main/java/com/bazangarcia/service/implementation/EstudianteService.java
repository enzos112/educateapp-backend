package com.bazangarcia.service.implementation;
import com.bazangarcia.service.interfaz.IEstudianteService;
import com.bazangarcia.repository.EstudianteRepository;
import com.bazangarcia.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findById(Integer id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante update(Integer id, Estudiante estudiante) {
        Estudiante estudianteExiste= estudianteRepository.findById(id).orElse(null);
        if (estudianteExiste==null)
        {
            return null;
        }
        estudianteExiste.setNombre(estudiante.getNombre());
        estudianteExiste.setApellido(estudiante.getApellido());
        estudianteExiste.setDni(estudiante.getDni());
        estudianteExiste.setCorreo(estudiante.getCorreo());
        estudianteExiste.setTelefono(estudiante.getTelefono());
        estudianteExiste.setDireccion(estudiante.getDireccion());
        estudianteExiste.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteExiste.setFechaIngreso(estudiante.getFechaIngreso());
        estudianteExiste.setEstado(estudiante.getEstado());

        return estudianteRepository.save(estudianteExiste);
    }

    @Override
    public void deleteById(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
