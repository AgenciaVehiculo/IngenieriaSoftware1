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
@Table(name="historico_cargo_empleado")
public class HistoricoCargo_empleado implements Serializable {
    @Id
    @Column(name="id_cargo_historico")
    int id_cargo_historico;
    @Column(name="Id_empleado")
    int id_empleado;
    @Column(name="fecha_inicial")
    String fecha_inicial;
    @Column(name="fecha_final")
    String fecha_final;
    @Column(name="id_cargo")
    int id_cargo;
    @Column(name="estado")
    boolean estado;

    public int getId_cargo_historico() {
        return id_cargo_historico;
    }

    public void setId_cargo_historico(int id_cargo_historico) {
        this.id_cargo_historico = id_cargo_historico;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
 
}
