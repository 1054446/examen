package com.jesus.examen.examen.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "examenopciones",schema = "examen")
public class OpcionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "opcion_id", updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long opcionId;

    @Column(name = "opcion")
    private String opcion;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pregunta_id")
    private PreguntaDto pregunta;
}
