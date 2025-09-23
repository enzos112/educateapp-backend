package com.bazangarcia.service.implementation;
import com.bazangarcia.config.DatabaseConfigSingleton;
import com.bazangarcia.config.ResponseDecorator;
import com.bazangarcia.config.ResponseDtoFactory;
import com.bazangarcia.dto.request.EstudianteRequestDto;
import com.bazangarcia.dto.response.EstudianteResponseDto;
import com.bazangarcia.exception.ResourceNotFoundException;
import com.bazangarcia.config.EstudianteMapper;
import com.bazangarcia.service.interfaz.IEstudianteService;
import com.bazangarcia.repository.EstudianteRepository;
import com.bazangarcia.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private EstudianteMapper estudianteMapper;
    @Autowired
    private ResponseDtoFactory responseDtoFactory;
    @Autowired
    private ResponseDecorator responseDecorator;
    private final DatabaseConfigSingleton dbConfig = DatabaseConfigSingleton.getInstance();


    public EstudianteResponseDto crearEstudiante(EstudianteRequestDto dto){
        dbConfig.printConfig();
        System.out.println("Creando estudiante con configuración: " + dbConfig.getMaxConnections() + " conexiones máximas");

        Estudiante estudiante = estudianteMapper.toEntity(dto);
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);

        //Aplicar Factory
        EstudianteResponseDto responseDto = (EstudianteResponseDto) responseDtoFactory.createResponseDto(
                ResponseDtoFactory.ESTUDIANTE_TYPE,
                estudianteGuardado
        );

        // Aplicar Decorator
        responseDecorator.logResponseCreation("Estudiante", estudianteGuardado.getId());
        return responseDecorator.decorateEstudianteResponse(responseDto);
    }

    /*public EstudianteResponseDto crearEstudiante (EstudianteRequestDto dto){
        Estudiante estudiante= estudianteMapper.toEntity(dto);
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        EstudianteResponseDto responseDto=estudianteMapper.toDto(estudianteGuardado);
        return responseDto;
    }*/

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findById(Integer id) {
        return estudianteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Estudiante", "id", id));
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante update(Integer id, Estudiante estudiante) {
        Estudiante estudianteExiste = estudianteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Estudiante", "id", id));
        estudianteExiste.setNombre(estudiante.getNombre());
        estudianteExiste.setApellido(estudiante.getApellido());
        estudianteExiste.setDni(estudiante.getDni());
        estudianteExiste.setCorreo(estudiante.getCorreo());
        estudianteExiste.setTelefono(estudiante.getTelefono());
        estudianteExiste.setDireccion(estudiante.getDireccion());
        estudianteExiste.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteExiste.setFechaIngreso(estudiante.getFechaIngreso());
        estudianteExiste.setEstado(estudiante.getEstado());

        return estudianteRepository.save(estudianteExiste);
    }

    public EstudianteResponseDto actualizarEstudiante(Integer id, EstudianteRequestDto dto) {
        Estudiante estudiante= estudianteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Estudiante", "id", id));
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setCorreo(dto.getCorreo());
        estudianteRepository.save(estudiante);
        return estudianteMapper.toDto(estudiante);
    }

    @Override
    public void deleteById(Integer id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante", "id", id));
        estudianteRepository.delete(estudiante);
    }
}
