package com.daw.DonChapato.service;

import com.daw.DonChapato.model.Orden;
import com.daw.DonChapato.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> findById(int id) {
        return ordenRepository.findById(id);
    }

    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    public void deleteById(int id) {
        ordenRepository.deleteById(id);
    }
}