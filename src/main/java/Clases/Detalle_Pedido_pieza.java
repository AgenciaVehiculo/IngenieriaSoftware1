/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jose_Castillo
 */
    @Entity
    @Table(name="pedido_pieza")
public class Detalle_Pedido_pieza implements Serializable {
    @Id
    @Column(name="ID_pedido_pieza")
    private int id_pedido_pieza;
    @Column(name="ID_pedido")
    private int id_pedido;
    @Column(name="ID_pieza")
    private int id_pieza;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="precio")
    private double precio;

    public int getId_pedido_pieza() {
        return id_pedido_pieza;
    }

    public void setId_pedido_pieza(int id_pedido_pieza) {
        this.id_pedido_pieza = id_pedido_pieza;
    }

    
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_pieza() {
        return id_pieza;
    }

    public void setId_pieza(int id_pieza) {
        this.id_pieza = id_pieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}

