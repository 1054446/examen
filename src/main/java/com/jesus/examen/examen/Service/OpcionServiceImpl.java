package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.OpcionDto;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Repository.OpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcionServiceImpl implements OpcionService{

    @Autowired
    OpcionRepository opcionRepository;

    @Override
    public RespuestaApi getOpcion(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(opcionRepository.findAll());
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi saveOpcion(OpcionDto opcionDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        OpcionDto opcionDtoResult = opcionRepository.save(opcionDto);
        respuestaApi.setResultado(opcionDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi updateOpcion(OpcionDto opcionDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        OpcionDto opcionDtoResult = opcionRepository.save(opcionDto);
        respuestaApi.setResultado(opcionDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi deleteOpcion(Long id){
        RespuestaApi respuestaApi = new RespuestaApi();
        opcionRepository.deleteById(id);
        respuestaApi.setResultado("deleted");
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }
}
