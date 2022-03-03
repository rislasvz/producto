package com.springboot.app.productos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private double precio;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;


    public Producto(Long idProducto, String nombre, double precio, Date createAt) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.createAt = createAt;
    }

    public Producto() {

    }


    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
