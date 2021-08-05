/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kur013
 */
@Entity
@Table(name="tipo_cabina")
public class TipoCabina implements Serializable {

    @Id
    @Column(name="id_tipo_cabina")
    private int idTipoCabina;
    @Column(name="tipo_cabina")
    private String tipoCabina;
    @Column
    private boolean estado;

    public int getIdTipoCabina() {
        return idTipoCabina;
    }

    public void setIdTipoCabina(int idTipoCabina) {
        this.idTipoCabina = idTipoCabina;
    }

    public String getTipoCabina() {
        return tipoCabina;
    }

    public void setTipoCabina(String tipoCabina) {
        this.tipoCabina = tipoCabina;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


 
}
