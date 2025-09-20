package com.bazangarcia.service.interfaz;
import com.bazangarcia.model.Estudiante;
import java.util.List;

public interface IEstudianteService {
    List<Estudiante> findAll();
    Estudiante findById(Integer id);
    Estudiante save(Estudiante estudiante);
    Estudiante update(Integer id, Estudiante estudiante);
    void deleteById(Integer id);
}
