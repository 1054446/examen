package com.jesus.examen.examen.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "estudiantes",schema = "examen")
public class EstudianteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "estudiante_id", updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long estudianteId;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "edad")
    private int edad;

    @Column(name = "ciudad")
    private String ciudad;

    @OneToOne(optional = false)
    @JoinColumn(name = "zonahoraria_id", referencedColumnName = "zonahoraria_id")
    private ZonaHorariaDto zona;
}
