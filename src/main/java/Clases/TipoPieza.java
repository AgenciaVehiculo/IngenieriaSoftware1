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
@Table(name = "tipo_pieza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPieza.findAll", query = "SELECT t FROM TipoPieza t")
    , @NamedQuery(name = "TipoPieza.findByIDtipopieza", query = "SELECT t FROM TipoPieza t WHERE t.iDtipopieza = :iDtipopieza")
    , @NamedQuery(name = "TipoPieza.findByTipopieza", query = "SELECT t FROM TipoPieza t WHERE t.tipopieza = :tipopieza")
    , @NamedQuery(name = "TipoPieza.findByEstado", query = "SELECT t FROM TipoPieza t WHERE t.estado = :estado")})
public class TipoPieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_tipo_pieza")
    private Integer iDtipopieza;
    @Column(name = "Tipo_pieza")
    private String tipopieza;
    @Column(name = "estado")
    private Boolean estado;

    public TipoPieza() {
    }

    public TipoPieza(Integer iDtipopieza) {
        this.iDtipopieza = iDtipopieza;
    }

    public Integer getIDtipopieza() {
        return iDtipopieza;
    }

    public void setIDtipopieza(Integer iDtipopieza) {
        this.iDtipopieza = iDtipopieza;
    }

    public String getTipopieza() {
        return tipopieza;
    }

    public void setTipopieza(String tipopieza) {
        this.tipopieza = tipopieza;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDtipopieza != null ? iDtipopieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPieza)) {
            return false;
        }
        TipoPieza other = (TipoPieza) object;
        if ((this.iDtipopieza == null && other.iDtipopieza != null) || (this.iDtipopieza != null && !this.iDtipopieza.equals(other.iDtipopieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.TipoPieza[ iDtipopieza=" + iDtipopieza + " ]";
    }
    
}
