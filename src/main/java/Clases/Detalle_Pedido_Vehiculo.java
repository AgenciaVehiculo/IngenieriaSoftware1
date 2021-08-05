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
@Table(name="pedido_vehiculo")
public class Detalle_Pedido_Vehiculo implements Serializable {
    @Id
    @Column(name="ID_pedido_Vehiculo")
    private int id_pedido_Vehiculo;
    @Column(name="ID_pedido")
    private int id_pedido;
    @Column(name="ID_vehiculo")
    private int id_vehiculo;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="precio")
    private double precio;

    public int getId_pedido_Vehiculo() {
        return id_pedido_Vehiculo;
    }

    public void setId_pedido_Vehiculo(int id_pedido_Vehiculo) {
        this.id_pedido_Vehiculo = id_pedido_Vehiculo;
    }



    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
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

