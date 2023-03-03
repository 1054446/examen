package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.EstudianteDto;
import com.jesus.examen.examen.Model.RespuestaApi;

public interface EstudianteService {

    RespuestaApi getEstudiantes();
    RespuestaApi saveEstudiante(EstudianteDto estudianteDto);
    RespuestaApi updateEstudiante(EstudianteDto estudianteDto);
    RespuestaApi deleteEstudiante(Long id);
    EstudianteDto getEstudianteById(Long id);
}
