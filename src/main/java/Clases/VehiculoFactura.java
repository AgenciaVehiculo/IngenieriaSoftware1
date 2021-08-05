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
@Table(name = "vehiculo_factura")

public class VehiculoFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="ID_factura_vehiculo")
    private int idFacturaVehiculo;
    @Column(name="ID_vehiculo")
    private int idVehiculo;
    @Column(name="ID_factura")
    private int idFactura;
    @Column(name = "vin")
    private String cantidad;
    

    
    public VehiculoFactura() {
    }

    public int getIdFacturaVehiculo() {
        return idFacturaVehiculo;
    }

    public void setIdFacturaVehiculo(int idFacturaVehiculo) {
        this.idFacturaVehiculo = idFacturaVehiculo;
    }

    
    
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
    

    

    @Override
    public String toString() {
        return "Clases.VehiculoFactura[ vehiculoFacturaPK=" + " ]";
    }
    
}
