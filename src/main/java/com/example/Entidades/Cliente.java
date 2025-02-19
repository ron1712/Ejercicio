package com.example.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Data
@Table(name = "tbl_clientes")
public class Cliente {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contrasena;
    private Boolean estado;
    @OneToMany(mappedBy = "cliente")
    private List<Cuenta> cuentas;
}
