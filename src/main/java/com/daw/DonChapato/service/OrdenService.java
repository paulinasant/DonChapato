package com.daw.DonChapato.service;

import com.daw.DonChapato.model.Orden;
import com.daw.DonChapato.repository.OrdenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> listarTodas() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> buscarPorId(Integer id) {
        return ordenRepository.findById(id);
    }

    public Orden crear(Orden orden) {
        return ordenRepository.save(orden);
    }

    public Orden actualizar(Integer id, Orden nuevaOrden) {
        return ordenRepository.findById(id)
                .map(orden -> {
                    orden.setEstado(nuevaOrden.getEstado());
                    orden.setCliente(nuevaOrden.getCliente());
                    orden.setUbicacion(nuevaOrden.getUbicacion());
                    return ordenRepository.save(orden);
                })
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
    }

    public void eliminar(Integer id) {
        ordenRepository.deleteById(id);
    }
}
