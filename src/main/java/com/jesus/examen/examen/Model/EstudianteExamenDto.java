package com.jesus.examen.examen.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "estudianteexamen",schema = "examen")
public class EstudianteExamenDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "estudianteexamen_id", updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long estudianteExamenId;

    @Column(name = "calificacion")
    private Double calificacion;

    @Column(name = "fecha_examen")
    private Timestamp fechaExamen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "examen_id")
    private ExamenDto examen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estudiante_id")
    private EstudianteDto estudiante;
}
