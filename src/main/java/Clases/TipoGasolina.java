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
@Table(name="tipo_gasolina")
public class TipoGasolina implements Serializable {

    @Id
    @Column(name="id_tipo_gasolina")
    private int idTipoGasolina;
    @Column(name="tipo_gasolina")
    private String tipoGasolina;
    @Column
    private boolean estado;

    public int getIdTipoGasolina() {
        return idTipoGasolina;
    }

    public void setIdTipoGasolina(int idTipoGasolina) {
        this.idTipoGasolina = idTipoGasolina;
    }

    public String getTipoGasolina() {
        return tipoGasolina;
    }

    public void setTipoGasolina(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
