package com.example.examen_final.controller;

import com.example.examen_final.entity.BarcoEntity;
import com.example.examen_final.services.BarcoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BarcoController {

    private final BarcoService barcoService;

    public BarcoController (BarcoService barcoService){
        this.barcoService = barcoService;
    }

    @PostMapping("/barco")
    public ResponseEntity<Void> crearCoordenasBarco(@RequestBody BarcoEntity barcoEntity){
        barcoService.ProcesarCoordenadas(barcoEntity.getCoordinates());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/game")
    public ResponseEntity<Map<String, Object>> buscarCoordenadasBarco(@RequestParam("coordinates") String[] coordinates){
        Map<String, Object> response = barcoService.buscarBarco(coordinates);

        if((int) response.get("code") == 200){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }
}
