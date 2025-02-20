package com.example.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private long numeroCuenta; // Corregido: Eliminar acento en "numero"
    private String tipoCuenta;
    private double saldo;
    private double saldoInicial; // Corregido: Eliminar acento en "inicial"
    private boolean estado;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Movimiento> movimientos;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(Cuenta cuenta, List<Movimiento> movimientos) {
    }

    public Cuenta(Cliente cliente, List<Cuenta> cuentas) {
    }
}
