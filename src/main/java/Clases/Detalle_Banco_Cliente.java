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
import javax.persistence.Table;

/**
 *
 * @author Jose_Castillo
 */
    @Entity
@Table(name="banco_cliente")
public class Detalle_Banco_Cliente implements Serializable {
    @Id
    @Column(name="numero_prestamo")
    private int numero_prestamo;
    @Column(name="id_banco")
    private int id_banco;
    @Column(name="Id_cliente")
    private int Id_cliente;
    @Column(name="monto_prestamo")
    private double monto_prestamo;
    @Column(name="cuota")
    private int cuota;
    @Column(name="valor_interes")
    private double valor_interes;
    @Column(name="tasa_interes")
    private double tasa_interes;
    @Column(name="valor_capital")
    private double valor_capital;
    @Column(name="fecha_inicio")
    private String fecha_inicio;
    @Column(name="fecha_final")
    private String fecha_final;
    @Column(name="estado")
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumero_prestamo() {
        return numero_prestamo;
    }

    public void setNumero_prestamo(int numero_prestamo) {
        this.numero_prestamo = numero_prestamo;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public int getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(int Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public double getMonto_prestamo() {
        return monto_prestamo;
    }

    public void setMonto_prestamo(double monto_prestamo) {
        this.monto_prestamo = monto_prestamo;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public double getValor_interes() {
        return valor_interes;
    }

    public void setValor_interes(double valor_interes) {
        this.valor_interes = valor_interes;
    }

    public double getTasa_interes() {
        return tasa_interes;
    }

    public void setTasa_interes(double tasa_interes) {
        this.tasa_interes = tasa_interes;
    }

    public double getValor_capital() {
        return valor_capital;
    }

    public void setValor_capital(double valor_capital) {
        this.valor_capital = valor_capital;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }
    

    
}

