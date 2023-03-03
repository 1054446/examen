package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.PreguntaDto;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaServiceImpl implements PreguntaService{

    @Autowired
    PreguntaRepository preguntaRepository;

    @Override
    public RespuestaApi getPregunta(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(preguntaRepository.findAll());
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi savePregunta(PreguntaDto preguntaDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        PreguntaDto preguntaDtoResult = preguntaRepository.save(preguntaDto);
        respuestaApi.setResultado(preguntaDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi updatePregunta(PreguntaDto preguntaDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        PreguntaDto preguntaDtoResult = preguntaRepository.save(preguntaDto);
        respuestaApi.setResultado(preguntaDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi deletePregunta(Long id){
        RespuestaApi respuestaApi = new RespuestaApi();
        preguntaRepository.deleteById(id);
        respuestaApi.setResultado("deleted");
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }
}
