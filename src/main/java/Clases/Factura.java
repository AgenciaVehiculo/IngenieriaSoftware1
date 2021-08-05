/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kur013
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIDFactura", query = "SELECT f FROM Factura f WHERE f.iDFactura = :iDFactura")
    , @NamedQuery(name = "Factura.findByFechaHora", query = "SELECT f FROM Factura f WHERE f.fechaHora = :fechaHora")
    , @NamedQuery(name = "Factura.findByEstado", query = "SELECT f FROM Factura f WHERE f.estado = :estado")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Factura")
    private Integer iDFactura;
    @Column(name = "fecha_hora")
    //@Temporal(TemporalType.TIMESTAMP)
    private String fechaHora;
    @Column(name="ID_empleado")
    private int idEmpleado;
    @Column(name="ID_Cliente")
    private int idCliente;
    
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "ID_tipo_factura")    
    private int iDtipofactura;
    

    public Factura() {
    }

    public Integer getiDFactura() {
        return iDFactura;
    }

    public void setiDFactura(Integer iDFactura) {
        this.iDFactura = iDFactura;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getiDtipofactura() {
        return iDtipofactura;
    }

    public void setiDtipofactura(int iDtipofactura) {
        this.iDtipofactura = iDtipofactura;
    }
    
    

    public Factura(Integer iDFactura) {
        this.iDFactura = iDFactura;
    }

    public Integer getIDFactura() {
        return iDFactura;
    }

    public void setIDFactura(Integer iDFactura) {
        this.iDFactura = iDFactura;
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
        hash += (iDFactura != null ? iDFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.iDFactura == null && other.iDFactura != null) || (this.iDFactura != null && !this.iDFactura.equals(other.iDFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Factura[ iDFactura=" + iDFactura + " ]";
    }
    
}
