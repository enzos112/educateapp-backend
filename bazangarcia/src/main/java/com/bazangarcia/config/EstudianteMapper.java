package com.bazangarcia.config;

import com.bazangarcia.dto.response.EstudianteResponseDto;
import org.springframework.stereotype.Component;
import com.bazangarcia.model.Estudiante;
import com.bazangarcia.dto.request.EstudianteRequestDto;

@Component
public class EstudianteMapper {
    public Estudiante toEntity(EstudianteRequestDto dto) {
        if(dto==null) return null;
        Estudiante estudiante=new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setCorreo(dto.getCorreo());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setDni(dto.getDni());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setFechaIngreso(dto.getFechaIngreso());
        return estudiante;

    }
    public EstudianteResponseDto toDto(Estudiante e){
        if (e==null)return null;
        EstudianteResponseDto response =new EstudianteResponseDto();
        response.setId(e.getId());
        response.setNombre(e.getNombre());
        response.setApellido(e.getApellido());
        response.setTelefono(e.getTelefono());
        response.setCorreo(e.getCorreo());
        response.setFechaIngreso(e.getFechaIngreso());

        return response;
    }
}
