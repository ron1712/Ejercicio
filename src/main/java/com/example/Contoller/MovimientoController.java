package com.example.Contoller;

import com.example.Entidades.Cliente;
import com.example.Entidades.Cuenta;
import com.example.Entidades.Movimiento;
import com.example.Servicios.ClienteServicio;
import com.example.Servicios.MovimientoServicio;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "movimientos")
public class MovimientoController {
    @Autowired
    private final MovimientoServicio movimientoServicio;
    public MovimientoController(MovimientoServicio movimientoServicio) {
        this.movimientoServicio = movimientoServicio;
    }
    @GetMapping
    public List<Movimiento> listarClientes() {
        return movimientoServicio.obtenerMovimientos();
    }

    @PostMapping
    public Movimiento guardarClientes(@RequestBody Movimiento movimiento) {
        movimientoServicio.crearMovimientos(movimiento);
        return movimiento;
    }

    @PostUpdate
    public void actualizarClientes(@RequestBody Movimiento movimiento) {
        movimientoServicio.actualizarMovimientos(movimiento);
    }

    @DeleteMapping("/{idMovimiento}")
    public void eliminarClientes(@PathVariable("idMovimiento") long  idMovimiento) {
        movimientoServicio.elminarMovimientos(idMovimiento);
    }
}
