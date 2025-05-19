package com.daw.DonChapato.service;


import com.daw.DonChapato.model.Ubicacion;
import com.daw.DonChapato.repository.UbicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    public UbicacionService(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    public List<Ubicacion> listarTodas() {
        return ubicacionRepository.findAll();
    }

    public Optional<Ubicacion> buscarPorId(Integer id) {
        return ubicacionRepository.findById(id);
    }

    public Ubicacion crear(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public Ubicacion actualizar(Integer id, Ubicacion nuevaUbicacion) {
        return ubicacionRepository.findById(id)
                .map(ubicacion -> {
                    ubicacion.setNombre(nuevaUbicacion.getNombre());
                    ubicacion.setDescripcion(nuevaUbicacion.getDescripcion());
                    return ubicacionRepository.save(ubicacion);
                })
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));
    }

    public void eliminar(Integer id) {
        ubicacionRepository.deleteById(id);
    }
}
