package com.daw.DonChapato.controller;

import com.daw.DonChapato.model.Ubicacion;
import com.daw.DonChapato.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping
    public List<Ubicacion> getAllUbicaciones() {
        return ubicacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> getUbicacionById(@PathVariable int id) {
        Optional<Ubicacion> ubicacion = ubicacionService.findById(id);
        return ubicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ubicacion createUbicacion(@RequestBody Ubicacion ubicacion) {
        return ubicacionService.save(ubicacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ubicacion> updateUbicacion(@PathVariable int id, @RequestBody Ubicacion ubicacionDetails) {
        Optional<Ubicacion> ubicacion = ubicacionService.findById(id);
        if (ubicacion.isPresent()) {
            Ubicacion updatedUbicacion = ubicacion.get();
            updatedUbicacion.setNombre(ubicacionDetails.getNombre());
            updatedUbicacion.setDescripcion(ubicacionDetails.getDescripcion());
            return ResponseEntity.ok(ubicacionService.save(updatedUbicacion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbicacion(@PathVariable int id) {
        ubicacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}