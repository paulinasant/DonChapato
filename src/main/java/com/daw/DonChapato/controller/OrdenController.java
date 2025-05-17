package com.daw.DonChapato.controller;

import com.daw.DonChapato.model.Orden;
import com.daw.DonChapato.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable int id) {
        Optional<Orden> orden = ordenService.findById(id);
        return orden.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Orden createOrden(@RequestBody Orden orden) {
        return ordenService.save(orden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable int id, @RequestBody Orden ordenDetails) {
        Optional<Orden> orden = ordenService.findById(id);
        if (orden.isPresent()) {
            Orden updatedOrden = orden.get();
            updatedOrden.setIdUbicacion(ordenDetails.getIdUbicacion());
            updatedOrden.setIdCliente(ordenDetails.getIdCliente());
            updatedOrden.setEstado(ordenDetails.getEstado());
            return ResponseEntity.ok(ordenService.save(updatedOrden));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable int id) {
        ordenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}