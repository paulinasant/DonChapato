package com.daw.DonChapato.service;


import com.daw.DonChapato.model.Producto;
import com.daw.DonChapato.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Integer id, Producto nuevoProducto) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(nuevoProducto.getNombre());
                    producto.setPrecio(nuevoProducto.getPrecio());
                    producto.setDescripcion(nuevoProducto.getDescripcion());
                    producto.setTipo(nuevoProducto.getTipo());
                    return productoRepository.save(producto);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}
