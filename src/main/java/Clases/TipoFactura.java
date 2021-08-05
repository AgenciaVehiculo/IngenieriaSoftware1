/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kur013
 */
@Entity
@Table(name = "tipo_factura")

public class TipoFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_tipo_factura")
    private Integer iDtipofactura;
    @Column(name = "tipo_factura")
    private String tipoFactura;
    @Column(name = "estado")
    private Boolean estado;
   

    public TipoFactura() {
    }

    public TipoFactura(Integer iDtipofactura) {
        this.iDtipofactura = iDtipofactura;
    }

    public Integer getIDtipofactura() {
        return iDtipofactura;
    }

    public void setIDtipofactura(Integer iDtipofactura) {
        this.iDtipofactura = iDtipofactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDtipofactura != null ? iDtipofactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFactura)) {
            return false;
        }
        TipoFactura other = (TipoFactura) object;
        if ((this.iDtipofactura == null && other.iDtipofactura != null) || (this.iDtipofactura != null && !this.iDtipofactura.equals(other.iDtipofactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.TipoFactura[ iDtipofactura=" + iDtipofactura + " ]";
    }
    
}
