package com.bazangarcia.controller;

import com.bazangarcia.dto.request.MatriculaRequestDto;
import com.bazangarcia.dto.response.MatriculaResponseDto;
import com.bazangarcia.config.MatriculaMapper;
import com.bazangarcia.model.Matricula;
import com.bazangarcia.service.implementation.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private MatriculaMapper matriculaMapper;

    @PostMapping("/matriculas")
    public MatriculaResponseDto crear(@RequestBody MatriculaRequestDto dto) {
        Matricula matricula = matriculaMapper.toEntity(dto);
        Matricula matriculaGuardada = matriculaService.save(matricula);
        return matriculaMapper.toDto(matriculaGuardada);
    }

    @GetMapping("/matriculas")
    public List<MatriculaResponseDto> listar() {
        List<Matricula> matriculas = matriculaService.findAll();
        List<MatriculaResponseDto> responseList = new ArrayList<>();
        for (Matricula m : matriculas) {
            MatriculaResponseDto responseDto = matriculaMapper.toDto(m);
            responseList.add(responseDto);
        }
        return responseList;
    }

    @GetMapping("/matriculas/{id}")
    public MatriculaResponseDto buscarPorId(@PathVariable Integer id) {
        Matricula matricula = matriculaService.findById(id);
        return matriculaMapper.toDto(matricula);
    }

    @DeleteMapping("/matriculas/{id}")
    public String eliminar(@PathVariable Integer id) {
        matriculaService.deleteById(id);
        return "Matrícula eliminada exitosamente";
    }

    @PutMapping("/matriculas/{id}")
    public MatriculaResponseDto actualizar(@PathVariable Integer id, @RequestBody MatriculaRequestDto dto) {
        Matricula matricula = matriculaMapper.toEntity(dto);
        Matricula matriculaActualizada = matriculaService.update(id, matricula);
        return matriculaMapper.toDto(matriculaActualizada);
    }
}
