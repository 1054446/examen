package com.jesus.examen.examen.Controller;

import com.jesus.examen.examen.Model.OpcionDto;
import com.jesus.examen.examen.Service.OpcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("opcion/v1")
public class OpcionController {

    @Autowired
    OpcionService opcionService;

    @GetMapping(value = "/consulta")
    public ResponseEntity<Object> getOpcion(){
        return new ResponseEntity<>(opcionService.getOpcion(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Object> saveOpcion(@RequestBody OpcionDto opcionDto){
        return new ResponseEntity<>(opcionService.saveOpcion(opcionDto), HttpStatus.OK);
    }

    @PutMapping(value = "/actualiza")
    public ResponseEntity<Object> updateOpcion(@RequestBody OpcionDto opcionDto){
        return new ResponseEntity<>(opcionService.updateOpcion(opcionDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/elimina/{id}")
    public ResponseEntity<Object> deleteOpcion(@PathVariable Long id){
        return new ResponseEntity<>(opcionService.deleteOpcion(id), HttpStatus.OK);
    }
}
