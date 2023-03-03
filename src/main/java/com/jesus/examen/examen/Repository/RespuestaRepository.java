package com.jesus.examen.examen.Repository;

import com.jesus.examen.examen.Model.RespuestaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaDto, Long> {

    @Query(value="select er.respuesta_id, er.estudianteexamen_id, er.pregunta_id, er.opcion_id from examenrespuestas as er\n" +
            "inner join estudianteexamen as e\n" +
            "on er.estudianteexamen_id = e.estudianteexamen_id\n" +
            "where e.estudiante_id =?1 and e.examen_id =?2", nativeQuery = true)
    List<RespuestaDto> findByEstudianteExamen(Long estudianteId, Long examenId);
}
