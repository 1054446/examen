package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.ExamenDto;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImpl implements ExamenService{

    @Autowired
    ExamenRepository examenRepository;

    @Override
    public RespuestaApi getExamen(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(examenRepository.findAll());
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi saveExamen(ExamenDto examenDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        ExamenDto examenDtoResult = examenRepository.save(examenDto);
        respuestaApi.setResultado(examenDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi updateExamen(ExamenDto examenDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        ExamenDto examenDtoResult = examenRepository.save(examenDto);
        respuestaApi.setResultado(examenDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi deleteExamen(Long id){
        RespuestaApi respuestaApi = new RespuestaApi();
        examenRepository.deleteById(id);
        respuestaApi.setResultado("deleted");
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }
}
