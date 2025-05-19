package com.daw.DonChapato.controller;

import com.daw.DonChapato.model.Tipo;
import com.daw.DonChapato.service.TipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tipos")
public class TipoController {

    private final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping
    public List<Tipo> listar() {
        return tipoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> buscarPorId(@PathVariable Integer id) {
        return tipoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tipo crear(@RequestBody Tipo tipo) {
        return tipoService.crear(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> actualizar(@PathVariable Integer id, @RequestBody Tipo tipo) {
        try {
            return ResponseEntity.ok(tipoService.actualizar(id, tipo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        tipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
