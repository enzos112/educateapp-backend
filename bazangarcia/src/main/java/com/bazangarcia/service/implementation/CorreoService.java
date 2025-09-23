package com.bazangarcia.service.implementation;

import com.bazangarcia.exception.ResourceNotFoundException;
import com.bazangarcia.model.Correo;
import com.bazangarcia.repository.CorreoRepository;
import com.bazangarcia.service.interfaz.ICorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorreoService implements ICorreoService {
    @Autowired
    private CorreoRepository correoRepository;

    @Override
    public List<Correo> findAll() {
        return correoRepository.findAll();
    }

    @Override
    public Correo findById(Integer id) {
        return correoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Correo", "id", id));
    }

    @Override
    public Correo save(Correo correo) {
        return correoRepository.save(correo);
    }

    @Override
    public Correo update(Integer id, Correo correo) {
        Correo correoExistente = correoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Correo", "id", id));

        correoExistente.setRemitente(correo.getRemitente());
        correoExistente.setDestinatario(correo.getDestinatario());
        correoExistente.setAsunto(correo.getAsunto());
        correoExistente.setContenido(correo.getContenido());

        return correoRepository.save(correoExistente);
    }

    @Override
    public void deleteById(Integer id) {
        Correo correo = correoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Correo", "id", id));
        correoRepository.delete(correo);
    }
}
