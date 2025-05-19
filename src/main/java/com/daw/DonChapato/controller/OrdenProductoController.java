package com.daw.DonChapato.controller;

import com.daw.DonChapato.model.OrdenProducto;
import com.daw.DonChapato.service.OrdenProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordenes-productos")
public class OrdenProductoController {


    private final OrdenProductoService ordenProductoService;

    public OrdenProductoController(OrdenProductoService ordenProductoService) {
        this.ordenProductoService = ordenProductoService;
    }

    @PostMapping
    public OrdenProducto agregar(@RequestBody OrdenProducto ordenProducto) {
        return ordenProductoService.agregar(ordenProducto);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestBody OrdenProducto ordenProducto) {
        ordenProductoService.eliminar(ordenProducto);
        return ResponseEntity.noContent().build();
    }
}
