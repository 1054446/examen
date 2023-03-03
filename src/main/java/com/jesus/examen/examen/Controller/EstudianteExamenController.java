package com.jesus.examen.examen.Controller;

import com.jesus.examen.examen.Model.EstudianteExamenDto;
import com.jesus.examen.examen.Service.EstudianteExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudiante-examen/v1")
public class EstudianteExamenController {

    @Autowired
    EstudianteExamenService estudianteExamenService;

    @GetMapping(value = "/consulta")
    public ResponseEntity<Object> getEstudianteExamen(){
        return new ResponseEntity<>(estudianteExamenService.getEstudianteExamen(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Object> saveEstudianteExamen(@RequestBody EstudianteExamenDto estudianteExamenDto){
        return new ResponseEntity<>(estudianteExamenService.saveEstudianteExamen(estudianteExamenDto), HttpStatus.OK);
    }

    @PutMapping(value = "/actualiza")
    public ResponseEntity<Object> updateEstudianteExamen(@RequestBody EstudianteExamenDto estudianteExamenDto){
        return new ResponseEntity<>(estudianteExamenService.updateEstudianteExamen(estudianteExamenDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/elimina/{id}")
    public ResponseEntity<Object> deleteEstudianteExamen(@PathVariable Long id){
        return new ResponseEntity<>(estudianteExamenService.deleteEstudianteExamen(id), HttpStatus.OK);
    }
}
