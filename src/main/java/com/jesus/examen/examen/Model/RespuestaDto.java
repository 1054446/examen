package com.jesus.examen.examen.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "examenrespuestas",schema = "examen")
public class RespuestaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "respuesta_id", updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long respuestaId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estudianteexamen_id")
    private EstudianteExamenDto estudianteExamen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pregunta_id")
    private PreguntaDto pregunta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "opcion_id")
    private OpcionDto opcion;
}
