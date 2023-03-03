package com.jesus.examen.examen.Repository;

import com.jesus.examen.examen.Model.ExamenDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<ExamenDto, Long> {
}
