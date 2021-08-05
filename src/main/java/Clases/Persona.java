/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kur013
 */
@Entity
@Table(name="persona")
public class Persona implements Serializable {
    @Id
    private int id_persona;
    @Column
    private String Nombre;
    @Column
    private String Apellido;
    @Column
    private String telefono;
    @Column 
    private String direccion;
    @Column
    private String correo_electroncio;
    @Column
    private int ID_tipo_documento;
    @Column
    private String documento_id;

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo_electroncio() {
        return correo_electroncio;
    }

    public void setCorreo_electroncio(String correo_electroncio) {
        this.correo_electroncio = correo_electroncio;
    }

    public int getID_tipo_documento() {
        return ID_tipo_documento;
    }

    public void setID_tipo_documento(int ID_tipo_documento) {
        this.ID_tipo_documento = ID_tipo_documento;
    }

    public String getDocumento_id() {
        return documento_id;
    }

    public void setDocumento_id(String documento_id) {
        this.documento_id = documento_id;
    }

   

   
    
}

