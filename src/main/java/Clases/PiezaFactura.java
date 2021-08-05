/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kur013
 */
@Entity
@Table(name = "pieza_factura")
public class PiezaFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="ID_factura_pieza")
    private int idFacturaPieza;
    @Column(name="ID_pieza")
    private int idPieza;
    @Column(name="ID_factura")
    private int idFactura;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    

    public PiezaFactura() {
    }

    public int getIdFacturaPieza() {
        return idFacturaPieza;
    }

    public void setIdFacturaPieza(int idFacturaPieza) {
        this.idFacturaPieza = idFacturaPieza;
    }
    
    

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    

    

    @Override
    
    public String toString() {
        return "Clases.PiezaFactura[ piezaFacturaPK=" +  " ]";
    }
    
}
