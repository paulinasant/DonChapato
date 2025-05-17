package com.daw.DonChapato.service;

import com.daw.DonChapato.model.Ubicacion;
import com.daw.DonChapato.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Ubicacion> findAll() {
        return ubicacionRepository.findAll();
    }

    public Optional<Ubicacion> findById(int id) {
        return ubicacionRepository.findById(id);
    }

    public Ubicacion save(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public void deleteById(int id) {
        ubicacionRepository.deleteById(id);
    }
}