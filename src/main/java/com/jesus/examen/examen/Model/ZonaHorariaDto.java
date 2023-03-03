package com.jesus.examen.examen.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "zonahoraria",schema = "examen")
public class ZonaHorariaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "zonahoraria_id", updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zonaHorariaId;

    @Column(name = "zone")
    private String zone;
}
