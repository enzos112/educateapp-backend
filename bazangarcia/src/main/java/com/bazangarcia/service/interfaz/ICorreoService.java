package com.bazangarcia.service.interfaz;
import com.bazangarcia.model.Correo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICorreoService {
    List<Correo> findAll();
    Correo findById(Integer id);
    Correo save(Correo correo);
    Correo update(Integer id, Correo correo);
    void deleteById(Integer id);
}
