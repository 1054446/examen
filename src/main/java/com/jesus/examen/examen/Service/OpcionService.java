package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.ExamenDto;
import com.jesus.examen.examen.Model.OpcionDto;
import com.jesus.examen.examen.Model.RespuestaApi;

public interface OpcionService {

    RespuestaApi getOpcion();
    RespuestaApi saveOpcion(OpcionDto opcionDto);
    RespuestaApi updateOpcion(OpcionDto opcionDto);
    RespuestaApi deleteOpcion(Long id);
}
