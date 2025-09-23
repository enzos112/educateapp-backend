package com.bazangarcia.controller;

import com.bazangarcia.model.Curso;
import com.bazangarcia.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/cursos")
    public Curso crear(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @GetMapping("/cursos")
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }
}