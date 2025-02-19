package com.example.Repositorio;

import com.example.Entidades.Cliente;
import com.example.Entidades.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovimientoRepositorio extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, Date fechaAfter, Date fechaBefore);
}
