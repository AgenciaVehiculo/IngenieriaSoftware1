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
 * @author EDUIN FLORES
 */
@Entity
@Table(name="usuario_empleado")
public class Usuarios implements Serializable{
    @Id
    private int id_Usuario;
    @Column
    private int id_Empleado;
    @Column(name="usuario")
    private String id_Nombre;
    @Column(name="contrasenia")
    private String Contrasenia;
    @Column
    private boolean estado;

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getId_Nombre() {
        return id_Nombre;
    }

    public void setId_Nombre(String id_Nombre) {
        this.id_Nombre = id_Nombre;
    }

    public String getContraseña() {
        return Contrasenia;
    }

    public void setContraseña(String Contraseña) {
        this.Contrasenia = Contraseña;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
