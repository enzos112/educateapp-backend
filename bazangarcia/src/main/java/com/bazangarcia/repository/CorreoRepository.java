package com.bazangarcia.repository;

import com.bazangarcia.model.Correo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorreoRepository extends JpaRepository<Correo, Integer> {
}
