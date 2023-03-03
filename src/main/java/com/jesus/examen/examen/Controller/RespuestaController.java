package com.jesus.examen.examen.Controller;

import com.jesus.examen.examen.Model.RespuestaDto;
import com.jesus.examen.examen.Service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("respuesta/v1")
public class RespuestaController {

    @Autowired
    RespuestaService respuestaService;

    @GetMapping(value = "/consulta")
    public ResponseEntity<Object> getRespuesta(){
        return new ResponseEntity<>(respuestaService.getRespuesta(), HttpStatus.OK);
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<Object> saveRespuesta(@RequestBody RespuestaDto respuestaDto){
        return new ResponseEntity<>(respuestaService.saveRespuesta(respuestaDto), HttpStatus.OK);
    }

    @PutMapping(value = "/actualiza")
    public ResponseEntity<Object> updateRespuesta(@RequestBody RespuestaDto respuestaDto){
        return new ResponseEntity<>(respuestaService.updateRespuesta(respuestaDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/elimina/{id}")
    public ResponseEntity<Object> deleteRespuesta(@PathVariable Long id){
        return new ResponseEntity<>(respuestaService.deleteRespuesta(id), HttpStatus.OK);
    }

    @GetMapping(value = "/consulta-estudiante-examen/{estudianteId}/{examenId}")
    public ResponseEntity<Object> findByEstudianteExamen(@PathVariable Long estudianteId, @PathVariable Long examenId){
        return new ResponseEntity<>(respuestaService.findByEstudianteExamen(estudianteId, examenId), HttpStatus.OK);
    }

    @GetMapping(value = "/calificacion/{estudianteId}/{examenId}")
    public ResponseEntity<Object> getCalificacion(@PathVariable Long estudianteId, @PathVariable Long examenId){
        return new ResponseEntity<>(respuestaService.getCalificacion(estudianteId, examenId), HttpStatus.OK);
    }
}
