package com.example.Contoller;

import com.example.Entidades.Cliente;
import com.example.Entidades.Cuenta;
import com.example.Entidades.Movi;
import com.example.Entidades.ReporteResultado;
import com.example.Servicios.ClienteServicio;
import com.example.Servicios.CuentaServicio;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PostUpdate;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "cuentas")
public class CuentaController {
    @Autowired
    private final CuentaServicio cuentaServicio;
    public CuentaController(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }
    @GetMapping
    public List<Cuenta> listarCuentas() {
        return cuentaServicio.obtenerCuentas();
    }

    @PostMapping
    public Cuenta guardarCuentas(@RequestBody Cuenta cuenta) {
        cuentaServicio.crearCuentas(cuenta);
        return cuenta;
    }

    @PostUpdate
    public void actualizarCuentas(@RequestBody Cuenta cuenta) {
        cuentaServicio.actualizarCuentas(cuenta);
    }

    @DeleteMapping("/{idCuenta}")
    public void eliminarCuentas(@PathVariable("idCuenta") long  idCuenta) {
        cuentaServicio.elminarCuentas(idCuenta);
    }

    @PostMapping("/{idCliente}/movimiento")
    public void registrarMovimiento(@PathVariable("idCliente") long  idCliente, @RequestBody Movi movimientoDTO) throws Exception {
        cuentaServicio.registrarMovimiento(idCliente, movimientoDTO.getMonto(), movimientoDTO.getDescripcion());
    }
    @GetMapping("/reportes")
    public List<Cuenta> obtenerEstadoCuenta(
            @RequestParam Long clienteId,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(fechaInicio);
        Date endDate = dateFormat.parse(fechaFin);

        return cuentaServicio.obtenerEstadoCuenta(clienteId, startDate, endDate);

    }
}

