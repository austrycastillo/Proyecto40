package com.proyecto40.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto40.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
