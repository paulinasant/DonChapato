package com.daw.DonChapato.service;

import com.daw.DonChapato.model.Tipo;
import com.daw.DonChapato.repository.TipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public List<Tipo> listarTodos() {
        return tipoRepository.findAll();
    }

    public Optional<Tipo> buscarPorId(Integer id) {
        return tipoRepository.findById(id);
    }

    public Tipo crear(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public Tipo actualizar(Integer id, Tipo nuevoTipo) {
        return tipoRepository.findById(id)
                .map(tipo -> {
                    tipo.setDescripcion(nuevoTipo.getDescripcion());
                    return tipoRepository.save(tipo);
                })
                .orElseThrow(() -> new RuntimeException("Tipo no encontrado"));
    }

    public void eliminar(Integer id) {
        tipoRepository.deleteById(id);
    }
}
