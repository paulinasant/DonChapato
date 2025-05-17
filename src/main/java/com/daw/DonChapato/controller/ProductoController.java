package com.daw.DonChapato.controller;

import com.daw.DonChapato.model.Producto;
import com.daw.DonChapato.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable int id, @RequestBody Producto productoDetails) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isPresent()) {
            Producto updatedProducto = producto.get();
            updatedProducto.setNombre(productoDetails.getNombre());
            updatedProducto.setPrecio(productoDetails.getPrecio());
            updatedProducto.setTipo(productoDetails.getTipo());
            updatedProducto.setDescripcion(productoDetails.getDescripcion());
            return ResponseEntity.ok(productoService.save(updatedProducto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}