package com.jesus.examen.examen.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "examenpreguntas",schema = "examen")
public class PreguntaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pregunta_id", updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long preguntasId;

    @Column(name = "pregunta")
    private String pregunta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "examen_id")
    private ExamenDto examen;
}
