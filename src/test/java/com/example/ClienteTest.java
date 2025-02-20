package com.example;

import com.example.Entidades.Cliente;
import com.example.Entidades.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

import java.util.ArrayList;
import java.util.List;

public class ClienteTest {
    @Test
    public void testCrearCliente() {
        // Datos de prueba
        Long id = 1L;
        String nombre = "Marianela Montalvo";
        String contrasena = "123";
        Boolean estado = true;
        List<Cuenta> cuentas = new ArrayList<>();

        // Crear instancia de Cliente
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setContrasena(contrasena);
        cliente.setEstado(estado);
        cliente.setCuentas(cuentas);

        // Comprobar que el objeto no es nulo
        AssertionErrors.assertNotNull(cliente.getContrasena(), cliente.getContrasena());

        // Comprobar los valores de los campos
        Assertions.assertEquals(id, cliente.getId());
        Assertions.assertEquals(nombre, cliente.getNombre());
        Assertions.assertEquals(contrasena, cliente.getContrasena());
        Assertions.assertEquals(estado, cliente.getEstado());
        Assertions.assertEquals(cuentas, cliente.getCuentas());
    }
}
