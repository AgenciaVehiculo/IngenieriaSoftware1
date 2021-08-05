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
public class transmision implements Serializable {
    @Id
    int id_transmision;
    @Column
    String transmision;
    @Column
    boolean estado;

    public int getId_transmision() {
        return id_transmision;
    }

    public void setId_transmision(int id_transmision) {
        this.id_transmision = id_transmision;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
