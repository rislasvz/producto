package com.springboot.app.productos.controller;

import com.springboot.app.productos.entity.Producto;
import com.springboot.app.productos.exception.ModelNotFoundException;
import com.springboot.app.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        List<Producto> productos = this.productoService.findAll();
        return new ResponseEntity<>(productos, productos !=null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public Producto detalle(@PathVariable Long id){
        return productoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto){
        Producto productNew = this.productoService.create(producto);
        return new ResponseEntity<>(productNew,productNew !=null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }


    @PutMapping
    public ResponseEntity<Producto> update(@RequestBody Producto producto){
        Producto productUpdate = this.productoService.update(producto);
        return new ResponseEntity<>(productUpdate,productUpdate !=null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long idCliente) throws Exception{
        Producto producto = productoService.findById(idCliente);
        if(producto == null){

            throw new ModelNotFoundException("Cliente no encontrado");
        }
        productoService.delete(idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
