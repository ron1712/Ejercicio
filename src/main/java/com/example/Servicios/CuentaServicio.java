package com.example.Servicios;

import com.example.Entidades.*;
import com.example.Repositorio.ClienteRepositorio;
import com.example.Repositorio.CuentaRepositorio;
import com.example.Repositorio.MovimientoRepositorio;
import com.example.Repositorio.PersonaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuentaServicio {
    @Autowired
    CuentaRepositorio cuentaRepositorio;
    @Autowired
    MovimientoRepositorio movimientoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cuenta> obtenerCuentas() {
        return  cuentaRepositorio.findAll();
    }
    @Transactional
    public  Cuenta crearCuentas(Cuenta cuenta) {
        return cuentaRepositorio.save(cuenta);
    }
    public  void elminarCuentas(long id) {
        cuentaRepositorio.deleteById(id);
    }
    public  void actualizarCuentas(Cuenta cuenta) {
        cuentaRepositorio.save(cuenta);
    }

    @Transactional
    public void registrarMovimiento(long cuentaId, long monto, String descripcion) throws Exception {
        Cuenta cuenta = cuentaRepositorio.findById(cuentaId).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        if (cuenta.getSaldo() + monto < 0) {
            throw new Exception("Saldo no disponible");
        }
        Movimiento movimiento = new Movimiento();
        movimiento.setValor(monto);
        movimiento.setTipoMovimiento(descripcion);
        movimiento.setFecha(new Date());
        movimiento.setCuenta(cuenta);
        movimientoRepositorio.save(movimiento);
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        cuentaRepositorio.save(cuenta);
}
    public List<Cuenta> obtenerEstadoCuenta(Long clienteId, Date startDate, Date endDate) {
        Cliente cliente = clienteRepositorio.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        List<Cuenta> cuentas = cuentaRepositorio.findByCliente(cliente);

        List<Cuenta> cuentaDetalles = cuentas.stream().map(cuenta -> {
            List<Movimiento> movimientos = movimientoRepositorio.findByCuentaIdAndFechaBetween(cuenta.getId(), startDate, endDate);
            cuenta.setMovimientos(movimientos);
            return cuenta;
        }).collect(Collectors.toList());

        return cuentaDetalles;
    }
}
