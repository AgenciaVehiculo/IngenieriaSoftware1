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

/**
 *
 * @author Jose_Castillo
 */
    @Entity
public class Vehiculo implements Serializable {
    @Id
    private int id_vehiculo;
    @Column
    private String vin;
    @Column
    private int id_marca;
    @Column
    private int id_tipo_color;
    @Column
    private int id_tipo_vehiculo;
    @Column
    private int id_tipo_gasolina;
    @Column
    private int id_numero_asientos;
    @Column
    private int id_tipo_cabina;
    @Column
    private int id_transmision;
    @Column
    private double total_cilindraje;
    @Column
    private int Stock;
    @Column
    private int Stock_minimo;
    @Column
    private int Stock_maximo;
    @Column
    private boolean estado;

    public int getId_tipo_cabina() {
        return id_tipo_cabina;
    }

    public void setId_tipo_cabina(int id_tipo_cabina) {
        this.id_tipo_cabina = id_tipo_cabina;
    }

        
    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_tipo_color() {
        return id_tipo_color;
    }

    public void setId_tipo_color(int id_tipo_color) {
        this.id_tipo_color = id_tipo_color;
    }

    public int getId_tipo_vehiculo() {
        return id_tipo_vehiculo;
    }

    public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
    }

    public int getId_tipo_gasolina() {
        return id_tipo_gasolina;
    }

    public void setId_tipo_gasolina(int id_tipo_gasolina) {
        this.id_tipo_gasolina = id_tipo_gasolina;
    }

    public int getId_numero_asientos() {
        return id_numero_asientos;
    }

    public void setId_numero_asientos(int id_numero_asientos) {
        this.id_numero_asientos = id_numero_asientos;
    }

    public int getId_transmision() {
        return id_transmision;
    }

    public void setId_transmision(int id_transmision) {
        this.id_transmision = id_transmision;
    }

    public double getTotal_cilindraje() {
        return total_cilindraje;
    }

    public void setTotal_cilindraje(double total_cilindraje) {
        this.total_cilindraje = total_cilindraje;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getStock_minimo() {
        return Stock_minimo;
    }

    public void setStock_minimo(int Stock_minimo) {
        this.Stock_minimo = Stock_minimo;
    }

    public int getStock_maximo() {
        return Stock_maximo;
    }

    public void setStock_maximo(int Stock_maximo) {
        this.Stock_maximo = Stock_maximo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

}

