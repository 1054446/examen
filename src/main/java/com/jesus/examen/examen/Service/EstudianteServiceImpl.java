package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.EstudianteDto;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public RespuestaApi getEstudiantes(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(estudianteRepository.findAll());
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi saveEstudiante(EstudianteDto estudianteDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        EstudianteDto estudianteDtoResult = estudianteRepository.save(estudianteDto);
        respuestaApi.setResultado(estudianteDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi updateEstudiante(EstudianteDto estudianteDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        EstudianteDto estudianteDtoResult = estudianteRepository.save(estudianteDto);
        respuestaApi.setResultado(estudianteDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi deleteEstudiante(Long id){
        RespuestaApi respuestaApi = new RespuestaApi();
        estudianteRepository.deleteById(id);
        respuestaApi.setResultado("deleted");
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public EstudianteDto getEstudianteById(Long estudianteId){
        Optional<EstudianteDto> estudianteDtoOp = estudianteRepository.findById(estudianteId);
        EstudianteDto estudiante;
        if (estudianteDtoOp.isPresent()) {
            EstudianteDto estudianteDtoResult = estudianteDtoOp.get();
            estudiante = estudianteDtoResult;
            return estudiante;
        } else {
            estudiante = null;
        }

        return estudiante;
    }
}
