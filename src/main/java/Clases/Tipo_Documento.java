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
public class Tipo_Documento implements Serializable {
    @Id
    int id_Tipo_Documento;
    @Column
    String documento;
    @Column
    boolean estado;

    public int getId_Tipo_Documento() {
        return id_Tipo_Documento;
    }

    public void setId_Tipo_Documento(int id_Tipo_Documento) {
        this.id_Tipo_Documento = id_Tipo_Documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
