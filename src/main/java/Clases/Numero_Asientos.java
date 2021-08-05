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
public class Numero_Asientos implements Serializable {
    @Id
    int id_Numero_Asientos;
    @Column
    String Numero_Asientos;
    @Column
    boolean estado;

    public int getId_Numero_Asientos() {
        return id_Numero_Asientos;
    }

    public void setId_Numero_Asientos(int id_Numero_Asientos) {
        this.id_Numero_Asientos = id_Numero_Asientos;
    }

    public String getNumero_Asientos() {
        return Numero_Asientos;
    }

    public void setNumero_Asientos(String Numero_Asientos) {
        this.Numero_Asientos = Numero_Asientos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
