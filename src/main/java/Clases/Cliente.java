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
 * @author Jose Castillo
 */
@Entity
public class Cliente implements Serializable {
    @Id
    private int id_cliente;
    @Column 
    private int id_Persona;
    @Column
    private boolean estado;
    @Column
    private String fecha_ingreso_sistema;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }
    

    

   

    public String getFecha_ingreso_sistema() {
        return fecha_ingreso_sistema;
    }

    public void setFecha_ingreso_sistema(String fecha_ingreso_sistema) {
        this.fecha_ingreso_sistema = fecha_ingreso_sistema;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
