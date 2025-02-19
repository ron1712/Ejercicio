package com.example.Servicios;

import com.example.Entidades.Cliente;
import com.example.Entidades.Persona;
import com.example.Repositorio.ClienteRepositorio;
import com.example.Repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    public List<Cliente> obtenerClientes() {
        return  clienteRepositorio.findAll();
    }
    public  void crearCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }
    public  void elminarCliente(long id) {
        clienteRepositorio.deleteById(id);
    }
    public  void actualizarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }
}
