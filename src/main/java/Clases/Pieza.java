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
 * @author Kur013
 */
@Entity
public class Pieza implements Serializable {
    @Id
    int id_Pieza;
    @Column 
    int id_Tipo_Pieza;
    @Column
    String nombre;
    @Column(name="Caracteristicas_pieza")
    String carateristica_Pieza;
    @Column
    int stock;
    @Column
    int stock_Minimo;
    @Column
    int stock_Maximo;
    @Column
    boolean estado;

    public int getId_Pieza() {
        return id_Pieza;
    }

    public void setId_Pieza(int id_Pieza) {
        this.id_Pieza = id_Pieza;
    }

    public int getId_Tipo_Pieza() {
        return id_Tipo_Pieza;
    }

    public void setId_Tipo_Pieza(int id_Tipo_Pieza) {
        this.id_Tipo_Pieza = id_Tipo_Pieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public String getCarateristica_Pieza() {
        return carateristica_Pieza;
    }

    public void setCarateristica_Pieza(String carateristica_Pieza) {
        this.carateristica_Pieza = carateristica_Pieza;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_Minimo() {
        return stock_Minimo;
    }

    public void setStock_Minimo(int stock_Minimo) {
        this.stock_Minimo = stock_Minimo;
    }

    public int getStock_Maximo() {
        return stock_Maximo;
    }

    public void setStock_Maximo(int stock_Maximo) {
        this.stock_Maximo = stock_Maximo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}
