package com.umg.proyecto.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/temperatura")
public class TemperaturaController {

    @GetMapping("/celsius/{valor}")
    public ResponseEntity<TemperaturaResponse> convertir(@PathVariable double valor) {

        double fahrenheit = (valor * 9.0 / 5.0) + 32;

        TemperaturaResponse response = new TemperaturaResponse(valor, fahrenheit);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}