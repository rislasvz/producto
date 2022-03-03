package com.springboot.app.productos.service;

import com.springboot.app.productos.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto create(Producto producto);
    Producto update(Producto producto);
    void delete(Long id);
}
