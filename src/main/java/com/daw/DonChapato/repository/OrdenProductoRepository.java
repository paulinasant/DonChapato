package com.daw.DonChapato.repository;

import com.daw.DonChapato.model.OrdenProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenProductoRepository<OrdenProductoId> extends JpaRepository<OrdenProducto, OrdenProductoId> {
    List<OrdenProducto> findByOrdenId(Long ordenId);
}