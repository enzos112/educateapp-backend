package com.bazangarcia.controller;

import com.bazangarcia.dto.request.EstudianteRequestDto;
import com.bazangarcia.dto.response.EstudianteResponseDto;
import com.bazangarcia.mapper.EstudianteMapper;
import com.bazangarcia.model.Estudiante;
import com.bazangarcia.service.implementation.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private EstudianteMapper estudianteMapper;

    @PostMapping("/estudiantes")
    public EstudianteResponseDto crear (@RequestBody EstudianteRequestDto dto){
        return estudianteService.crearEstudiante(dto);
    }

    @GetMapping("/estudiantes")
    public List<EstudianteResponseDto> buscartodo (){
        List<Estudiante> lista=estudianteService.findAll();
        List<EstudianteResponseDto> responseList = new ArrayList<>();
        for (Estudiante e : lista){
            EstudianteResponseDto responseDto=estudianteMapper.toDto(e);
            responseList.add(responseDto);
        }
        return responseList;
    }

    @GetMapping("/estudiantes/{id}")
    public EstudianteResponseDto buscarxid (@PathVariable Integer id){
        Estudiante estudiante= estudianteService.findById(id);
        EstudianteResponseDto responseDto= estudianteMapper.toDto(estudiante);
        return responseDto;
    }

    @PutMapping("/estudiantes/{id}")
    public EstudianteResponseDto actualizar(@PathVariable Integer id, @RequestBody EstudianteRequestDto dto) {
        return estudianteService.actualizarEstudiante(id, dto);
    }

    @DeleteMapping("/estudiantes/{id}")
    public String eliminar(@PathVariable Integer id) {
        estudianteService.deleteById(id);
        return "Estudiante eliminado exitosamente";
    }

}
