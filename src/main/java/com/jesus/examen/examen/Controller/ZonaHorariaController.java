package com.jesus.examen.examen.Controller;

import com.jesus.examen.examen.Model.ZonaHorariaDto;
import com.jesus.examen.examen.Service.ZonaHorariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("zona-horaria/v1")
public class ZonaHorariaController {

    @Autowired
    ZonaHorariaService zonaHorariaService;

    @GetMapping(value = "/consulta")
    public ResponseEntity<Object> getZonaHoraria(){
        return new ResponseEntity<>(zonaHorariaService.getZona(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Object> saveZonaHoraria(@RequestBody ZonaHorariaDto zonaHorariaDto){
        return new ResponseEntity<>(zonaHorariaService.saveZona(zonaHorariaDto), HttpStatus.OK);
    }

    @PutMapping(value = "/actualiza")
    public ResponseEntity<Object> updateZonaHoraria(@RequestBody ZonaHorariaDto zonaHorariaDto){
        return new ResponseEntity<>(zonaHorariaService.updateZona(zonaHorariaDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/elimina/{id}")
    public ResponseEntity<Object> deleteZonaHoraria(@PathVariable Long id){
        return new ResponseEntity<>(zonaHorariaService.deleteZona(id), HttpStatus.OK);
    }
}
