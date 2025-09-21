package com.bazangarcia.repository;
import com.bazangarcia.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{
    // Método para obtener solo matrículas activas
    List<Matricula> findByEstadoTrue();
}
