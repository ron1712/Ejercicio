package com.example.Servicios;

import com.example.Entidades.Movimiento;
import com.example.Entidades.Persona;
import com.example.Repositorio.MovimientoRepositorio;
import com.example.Repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServicio {
    @Autowired
    MovimientoRepositorio movimientoRepositorio;

    public List<Movimiento> obtenerMovimientos() {
        return  movimientoRepositorio.findAll();
    }
    public  Movimiento crearMovimientos(Movimiento movimiento) {
       return movimientoRepositorio.save(movimiento);
    }
    public  void elminarMovimientos(long id) {
        movimientoRepositorio.deleteById(id);
    }
    public  void actualizarMovimientos(Movimiento movimiento) {
        movimientoRepositorio.save(movimiento);
    }
}
