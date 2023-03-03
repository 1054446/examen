package com.jesus.examen.examen.Repository;

import com.jesus.examen.examen.Model.EstudianteExamenDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteExamenRepository extends JpaRepository<EstudianteExamenDto, Long> {
}
