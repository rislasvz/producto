package com.springboot.app.productos.repository;

import com.springboot.app.productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducto extends JpaRepository<Producto, Long> {

}
