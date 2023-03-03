package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.CalificacionResponse;
import com.jesus.examen.examen.Model.OpcionDto;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Model.RespuestaDto;

import java.util.List;

public interface RespuestaService {

    RespuestaApi getRespuesta();
    RespuestaApi saveRespuesta(RespuestaDto respuestaDto);
    RespuestaApi updateRespuesta(RespuestaDto respuestaDto);
    RespuestaApi deleteRespuesta(Long id);
    RespuestaApi findByEstudianteExamen(Long estudianteId, Long examenId);

    RespuestaApi getCalificacion(Long estudianteId, Long examenId);
}
