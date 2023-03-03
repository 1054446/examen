package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.EstudianteExamenDto;
import com.jesus.examen.examen.Model.ExamenDto;
import com.jesus.examen.examen.Model.RespuestaApi;

public interface EstudianteExamenService {

    RespuestaApi getEstudianteExamen();
    RespuestaApi saveEstudianteExamen(EstudianteExamenDto estudianteExamenDto);
    RespuestaApi updateEstudianteExamen(EstudianteExamenDto estudianteExamenDto);
    RespuestaApi deleteEstudianteExamen(Long id);
}
