package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.ExamenDto;
import com.jesus.examen.examen.Model.RespuestaApi;

public interface ExamenService {

    RespuestaApi getExamen();
    RespuestaApi saveExamen(ExamenDto examenDto);
    RespuestaApi updateExamen(ExamenDto examenDto);
    RespuestaApi deleteExamen(Long id);
}
