package com.itm.festivos.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Health", description = "Endpoints de verificación")
@RestController
@RequestMapping("/api")
public class HealthController {

    @Operation(summary = "Ping de salud", description = "Devuelve OK si el servicio está arriba")
    @GetMapping("/ok")
    public ResponseEntity<String> ok() {
        return ResponseEntity.ok("OK");
    }
}
