package com.daw.DonChapato.service;

import com.daw.DonChapato.model.OrdenProducto;
import com.daw.DonChapato.repository.OrdenProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenProductoService {

    private final OrdenProductoRepository ordenProductoRepository;

    public OrdenProductoService(OrdenProductoRepository ordenProductoRepository) {
        this.ordenProductoRepository = ordenProductoRepository;
    }

    public List<OrdenProducto> listarTodos() {
        return ordenProductoRepository.findAll();
    }

    public OrdenProducto agregar(OrdenProducto ordenProducto) {
        return ordenProductoRepository.save(ordenProducto);
    }

    public void eliminar(OrdenProducto ordenProducto) {
        ordenProductoRepository.delete(ordenProducto);
    }
}
