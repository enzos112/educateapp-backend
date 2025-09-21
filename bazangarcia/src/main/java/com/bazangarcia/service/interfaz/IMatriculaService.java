package com.bazangarcia.service.interfaz;
import com.bazangarcia.model.Matricula;
import java.util.List;

public interface IMatriculaService {
    List<Matricula> findAll();
    Matricula findById(Integer id);
    Matricula save(Matricula matricula);
    Matricula update(Integer id, Matricula matricula);
    void deleteById(Integer id);
    // Método específico para matrículas activas
    List<Matricula> findActiveMatriculas();
}
