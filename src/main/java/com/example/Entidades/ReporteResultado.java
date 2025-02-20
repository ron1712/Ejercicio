package com.example.Entidades;

import lombok.Data;

import java.util.Date;
@Data
public class ReporteResultado {
    private Date fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipo;
    private double saldoInicial;
    private boolean estado;
    private double movimiento;
    private double saldoDisponible;

    public ReporteResultado(Date fecha, String cliente, String numeroCuenta, String tipo, double saldoInicial, boolean estado, double movimiento, double saldoDisponible) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.movimiento = movimiento;
        this.saldoDisponible = saldoDisponible;
    }

    public ReporteResultado(Date fecha, String nombre, long numeroCuenta, String tipoCuenta, double saldoInicial, boolean estado, double totalMovimientos, double saldoDisponible) {

    }
}

