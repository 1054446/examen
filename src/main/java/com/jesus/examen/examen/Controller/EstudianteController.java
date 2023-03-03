package com.jesus.examen.examen.Controller;

import com.jesus.examen.examen.Model.EstudianteDto;
import com.jesus.examen.examen.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudiante/v1")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping(value = "/consulta")
    public ResponseEntity<Object> getEstudiante(){
        return new ResponseEntity<>(estudianteService.getEstudiantes(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Object> saveEstudiante(@RequestBody EstudianteDto estudianteDto){
        return new ResponseEntity<>(estudianteService.saveEstudiante(estudianteDto), HttpStatus.OK);
    }

    @PutMapping(value = "/actualiza")
    public ResponseEntity<Object> updateEstudiante(@RequestBody EstudianteDto estudianteDto){
        return new ResponseEntity<>(estudianteService.updateEstudiante(estudianteDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/elimina/{id}")
    public ResponseEntity<Object> deleteEstudiante(@PathVariable Long id){
        return new ResponseEntity<>(estudianteService.deleteEstudiante(id), HttpStatus.OK);
    }
}
