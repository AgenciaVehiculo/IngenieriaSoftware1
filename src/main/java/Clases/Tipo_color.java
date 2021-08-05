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
 * @author Usuario
 */
@Entity
public class Tipo_color implements Serializable {
    @Id
    int id_tipo_color;
    @Column
    String tipo_color;
    @Column
    boolean estado;

    public int getId_tipo_color() {
        return id_tipo_color;
    }

    public void setId_tipo_color(int id_tipo_color) {
        this.id_tipo_color = id_tipo_color;
    }

    public String getTipo_color() {
        return tipo_color;
    }

    public void setTipo_color(String tipo_color) {
        this.tipo_color = tipo_color;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
