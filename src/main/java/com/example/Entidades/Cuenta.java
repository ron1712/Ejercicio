package com.example.Entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tbl_cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long númeroCuenta;
    private String tipoCuenta;
    private double saldo;
    private double saldoIncial;
    private boolean estado;
    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
    private List<Movimiento> movimientos;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Cuenta(Cuenta cuenta, List<Movimiento> movimientos) {

    }

    public Cuenta() {

    }

    public Cuenta(Cliente cliente, List<Cuenta> cuenta) {

    }
}
