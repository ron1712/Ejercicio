package com.example.Contoller;

import com.example.Entidades.Cliente;
import com.example.Entidades.Cuenta;
import com.example.Servicios.ClienteServicio;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "clientes")
public class ClienteController {
    @Autowired
    private final ClienteServicio clienteServicio;
    public ClienteController(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteServicio.obtenerClientes();
    }

    @PostMapping
    public Cliente guardarClientes(@RequestBody Cliente cliente) {
        clienteServicio.crearCliente(cliente);
        return cliente;
    }

    @PostUpdate
    public void actualizarClientes(@RequestBody Cliente cliente) {
        clienteServicio.actualizarCliente(cliente);
    }

    @DeleteMapping("/{idCliente}")
    public void eliminarClientes(@PathVariable("idCliente") long  idCliente) {
        clienteServicio.elminarCliente(idCliente);
    }
}
