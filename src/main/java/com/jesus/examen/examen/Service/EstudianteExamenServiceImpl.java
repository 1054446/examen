package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.EstudianteDto;
import com.jesus.examen.examen.Model.EstudianteExamenDto;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Repository.EstudianteExamenRepository;
import com.jesus.examen.examen.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class EstudianteExamenServiceImpl implements EstudianteExamenService {

    @Autowired
    EstudianteExamenRepository estudianteExamenRepository;

    @Autowired
    EstudianteServiceImpl estudianteService;

    @Override
    public RespuestaApi getEstudianteExamen(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(estudianteExamenRepository.findAll());
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi saveEstudianteExamen(EstudianteExamenDto estudianteExamenDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        Long id = estudianteExamenDto.getEstudiante().getEstudianteId();
        EstudianteDto estudiante = estudianteService.getEstudianteById(id);
        if(estudiante != null){
            Date date = new Date();
            date = estudianteExamenDto.getFechaExamen();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Use Madrid's time zone to format the date in
            df.setTimeZone(TimeZone.getTimeZone(estudiante.getZona().getZone()));
            df.format(date);

            estudianteExamenDto.setFechaExamen(Timestamp.valueOf(df.format(estudianteExamenDto.getFechaExamen())));
            EstudianteExamenDto estudianteExamenDtoResult = estudianteExamenRepository.save(estudianteExamenDto);
            respuestaApi.setResultado(estudianteExamenDtoResult);
            respuestaApi.setMensaje("OK");
        }else{
            respuestaApi.setResultado(null);
            respuestaApi.setMensaje("No se encontro el alumno");
        }

        return respuestaApi;
    }

    @Override
    public RespuestaApi updateEstudianteExamen(EstudianteExamenDto estudianteExamenDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        EstudianteExamenDto estudianteExamenDtoResult = estudianteExamenRepository.save(estudianteExamenDto);
        respuestaApi.setResultado(estudianteExamenDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi deleteEstudianteExamen(Long id){
        RespuestaApi respuestaApi = new RespuestaApi();
        estudianteExamenRepository.deleteById(id);
        respuestaApi.setResultado("deleted");
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }
}
