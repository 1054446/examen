package com.jesus.examen.examen.Repository;

import com.jesus.examen.examen.Model.EstudianteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteDto, Long> {
    }
