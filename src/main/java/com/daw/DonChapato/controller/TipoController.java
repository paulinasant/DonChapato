package com.daw.DonChapato.controller;

import com.daw.DonChapato.model.Tipo;
import com.daw.DonChapato.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public List<Tipo> getAllTipos() {
        return tipoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> getTipoById(@PathVariable int id) {
        Optional<Tipo> tipo = tipoService.findById(id);
        return tipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tipo createTipo(@RequestBody Tipo tipo) {
        return tipoService.save(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> updateTipo(@PathVariable int id, @RequestBody Tipo tipoDetails) {
        Optional<Tipo> tipo = tipoService.findById(id);
        if (tipo.isPresent()) {
            Tipo updatedTipo = tipo.get();
            updatedTipo.setDescripcion(tipoDetails.getDescripcion());
            return ResponseEntity.ok(tipoService.save(updatedTipo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable int id) {
        tipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}