package com.jesus.examen.examen.Controller;

import com.jesus.examen.examen.Model.ExamenDto;
import com.jesus.examen.examen.Service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("examen/v1")
public class ExamenController {

    @Autowired
    ExamenService examenService;

    @GetMapping(value = "/consulta")
    public ResponseEntity<Object> getExamen(){
        return new ResponseEntity<>(examenService.getExamen(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Object> saveExamen(@RequestBody ExamenDto examenDto){
        return new ResponseEntity<>(examenService.saveExamen(examenDto), HttpStatus.OK);
    }

    @PutMapping(value = "/actualiza")
    public ResponseEntity<Object> updateExamen(@RequestBody ExamenDto examenDto){
        return new ResponseEntity<>(examenService.updateExamen(examenDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/elimina/{id}")
    public ResponseEntity<Object> deleteExamen(@PathVariable Long id){
        return new ResponseEntity<>(examenService.deleteExamen(id), HttpStatus.OK);
    }
}
