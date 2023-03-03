package com.jesus.examen.examen.Controller;

import com.jesus.examen.examen.Model.PreguntaDto;
import com.jesus.examen.examen.Service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pregunta/v1")
public class PreguntaController {

    @Autowired
    PreguntaService preguntaService;

    @GetMapping(value = "/consulta")
    public ResponseEntity<Object> getPregunta(){
        return new ResponseEntity<>(preguntaService.getPregunta(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Object> savePregunta(@RequestBody PreguntaDto preguntaDto){
        return new ResponseEntity<>(preguntaService.savePregunta(preguntaDto), HttpStatus.OK);
    }

    @PutMapping(value = "/actualiza")
    public ResponseEntity<Object> updatePregunta(@RequestBody PreguntaDto preguntaDto){
        return new ResponseEntity<>(preguntaService.updatePregunta(preguntaDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/elimina/{id}")
    public ResponseEntity<Object> deletePregunta(@PathVariable Long id){
        return new ResponseEntity<>(preguntaService.deletePregunta(id), HttpStatus.OK);
    }
}
