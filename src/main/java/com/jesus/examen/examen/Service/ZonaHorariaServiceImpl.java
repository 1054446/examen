package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.ZonaHorariaDto;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Repository.ZonaHorariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZonaHorariaServiceImpl implements  ZonaHorariaService{

    @Autowired
    ZonaHorariaRepository zonaHorariaRepository;

    @Override
    public RespuestaApi getZona(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(zonaHorariaRepository.findAll());
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi saveZona(ZonaHorariaDto zonaHorariaDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        ZonaHorariaDto zonaDtoResult = zonaHorariaRepository.save(zonaHorariaDto);
        respuestaApi.setResultado(zonaDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi updateZona(ZonaHorariaDto zonaHorariaDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        ZonaHorariaDto zonaDtoResult = zonaHorariaRepository.save(zonaHorariaDto);
        respuestaApi.setResultado(zonaDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi deleteZona(Long id){
        RespuestaApi respuestaApi = new RespuestaApi();
        zonaHorariaRepository.deleteById(id);
        respuestaApi.setResultado("deleted");
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }
}
