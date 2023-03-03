package com.jesus.examen.examen.Repository;

import com.jesus.examen.examen.Model.PreguntaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaDto, Long> {
}
