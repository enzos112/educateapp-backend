package com.bazangarcia.controller;

import com.bazangarcia.model.Correo;
import com.bazangarcia.service.implementation.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CorreoController {

    @Autowired
    private CorreoService correoService;

    @GetMapping("/correos")
    public ResponseEntity<List<Correo>> findAll() throws Exception{
        List<Correo> list=correoService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/correos/{id}")
    public ResponseEntity<Correo> findById(@PathVariable("id") Integer id) throws Exception{
        Correo obj=correoService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/correos")
    public ResponseEntity<Correo> save(@RequestBody Correo correo) throws Exception {
        Correo obj = correoService.save(correo);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/correos/{id}")
    public ResponseEntity<Correo> update(@PathVariable("id") Integer id, @RequestBody Correo correo) throws Exception{
        Correo obj =  correoService.update(id, correo);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/correos/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        correoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
