package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.OpcionDto;
import com.jesus.examen.examen.Model.PreguntaDto;
import com.jesus.examen.examen.Model.RespuestaApi;

public interface PreguntaService {

    RespuestaApi getPregunta();
    RespuestaApi savePregunta(PreguntaDto preguntaDto);
    RespuestaApi updatePregunta(PreguntaDto preguntaDto);
    RespuestaApi deletePregunta(Long id);
}
