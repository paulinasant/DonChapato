package com.daw.DonChapato.repository;

import com.daw.DonChapato.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}