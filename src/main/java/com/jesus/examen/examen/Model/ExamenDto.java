package com.jesus.examen.examen.Model;

import lombok.Data;
import lombok.ToString;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "examenes",schema = "examen")
public class ExamenDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "examen_id", updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long examenId;

    @Column(name = "nombre")
    private String nombre;
}
