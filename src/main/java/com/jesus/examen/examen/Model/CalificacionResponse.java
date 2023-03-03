package com.jesus.examen.examen.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CalificacionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private EstudianteExamenDto estudianteExamen;
}
