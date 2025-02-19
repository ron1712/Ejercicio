package com.example.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
