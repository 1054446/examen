package com.jesus.examen.examen.Repository;

import com.jesus.examen.examen.Model.OpcionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionRepository extends JpaRepository<OpcionDto, Long> {
}
