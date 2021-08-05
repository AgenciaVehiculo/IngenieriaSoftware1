/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kur013
 */
@Entity
@Table(name = "historico_precio_pieza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoPrecioPieza.findAll", query = "SELECT h FROM HistoricoPrecioPieza h")
    , @NamedQuery(name = "HistoricoPrecioPieza.findByIdPrecioHistorico", query = "SELECT h FROM HistoricoPrecioPieza h WHERE h.idPrecioHistorico = :idPrecioHistorico")
    , @NamedQuery(name = "HistoricoPrecioPieza.findByFechaInicial", query = "SELECT h FROM HistoricoPrecioPieza h WHERE h.fechaInicial = :fechaInicial")
    , @NamedQuery(name = "HistoricoPrecioPieza.findByFechaFinal", query = "SELECT h FROM HistoricoPrecioPieza h WHERE h.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "HistoricoPrecioPieza.findByPrecio", query = "SELECT h FROM HistoricoPrecioPieza h WHERE h.precio = :precio")
    , @NamedQuery(name = "HistoricoPrecioPieza.findByEstado", query = "SELECT h FROM HistoricoPrecioPieza h WHERE h.estado = :estado")})
public class HistoricoPrecioPieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_precio_historico")
    private Integer idPrecioHistorico;
    @Column(name="ID_Pieza")
    private Integer idPieza;
    @Column(name = "fecha_inicial")
    private String fechaInicial;
    @Column(name = "fecha_final")
    private String fechaFinal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "estado")
    private Boolean estado;

    public HistoricoPrecioPieza() {
    }

    public Integer getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(Integer idPieza) {
        this.idPieza = idPieza;
    }
    
    

    public HistoricoPrecioPieza(Integer idPrecioHistorico) {
        this.idPrecioHistorico = idPrecioHistorico;
    }

    public Integer getIdPrecioHistorico() {
        return idPrecioHistorico;
    }

    public void setIdPrecioHistorico(Integer idPrecioHistorico) {
        this.idPrecioHistorico = idPrecioHistorico;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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
        hash += (idPrecioHistorico != null ? idPrecioHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoPrecioPieza)) {
            return false;
        }
        HistoricoPrecioPieza other = (HistoricoPrecioPieza) object;
        if ((this.idPrecioHistorico == null && other.idPrecioHistorico != null) || (this.idPrecioHistorico != null && !this.idPrecioHistorico.equals(other.idPrecioHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.HistoricoPrecioPieza[ idPrecioHistorico=" + idPrecioHistorico + " ]";
    }
    
}
