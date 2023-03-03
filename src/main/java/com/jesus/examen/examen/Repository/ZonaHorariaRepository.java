package com.jesus.examen.examen.Repository;

import com.jesus.examen.examen.Model.ZonaHorariaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaHorariaRepository extends JpaRepository<ZonaHorariaDto, Long> {
}
