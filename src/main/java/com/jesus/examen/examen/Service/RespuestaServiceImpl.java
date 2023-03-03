package com.jesus.examen.examen.Service;

import com.jesus.examen.examen.Model.CalificacionResponse;
import com.jesus.examen.examen.Model.RespuestaApi;
import com.jesus.examen.examen.Model.RespuestaDto;
import com.jesus.examen.examen.Repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaServiceImpl implements RespuestaService{

    @Autowired
    RespuestaRepository respuestaRepository;

    @Override
    public RespuestaApi getRespuesta(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(respuestaRepository.findAll());
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi saveRespuesta(RespuestaDto respuestaDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        RespuestaDto respuestaDtoResult = respuestaRepository.save(respuestaDto);
        respuestaApi.setResultado(respuestaDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi updateRespuesta(RespuestaDto respuestaDto){
        RespuestaApi respuestaApi = new RespuestaApi();
        RespuestaDto respuestaDtoResult = respuestaRepository.save(respuestaDto);
        respuestaApi.setResultado(respuestaDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi deleteRespuesta(Long id){
        RespuestaApi respuestaApi = new RespuestaApi();
        respuestaRepository.deleteById(id);
        respuestaApi.setResultado("deleted");
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi findByEstudianteExamen(Long estudianteId, Long respuestaId){
        RespuestaApi respuestaApi = new RespuestaApi();
        List<RespuestaDto> respuestaDtoResult = respuestaRepository.findByEstudianteExamen(estudianteId, respuestaId);
        respuestaApi.setResultado(respuestaDtoResult);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }

    @Override
    public RespuestaApi getCalificacion(Long estudianteId, Long respuestaId){
        RespuestaApi respuestaApi = new RespuestaApi();
        List<RespuestaDto> respuestaDtoResult = respuestaRepository.findByEstudianteExamen(estudianteId, respuestaId);
        CalificacionResponse response = new CalificacionResponse();
        if(respuestaDtoResult != null) {
            int respuestasCorrecta = 0;
            int preguntas = respuestaDtoResult.size();
            double promedio = 0;

            List<RespuestaDto> filtrado = respuestaDtoResult.stream().filter(item -> item.getOpcion().isCorrect()).collect(Collectors.toList());
            filtrado.forEach(item -> System.out.println(item));
            respuestasCorrecta = filtrado.size();
            System.out.println("total preguntas " + preguntas);
            System.out.println("total de correctas " + respuestasCorrecta);
            response.setEstudianteExamen(filtrado.get(0).getEstudianteExamen());
            promedio = preguntas / respuestasCorrecta * 100;
            System.out.println("promedio ---> "+ promedio);
            response.getEstudianteExamen().setCalificacion(promedio);
        }

        respuestaApi.setResultado(response);
        respuestaApi.setMensaje("OK");
        return respuestaApi;
    }
}
