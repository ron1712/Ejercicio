package com.example.Servicios;

import com.example.Entidades.Persona;
import com.example.Repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicio {
    @Autowired
    PersonaRepositorio personaRepositorio;

    public List<Persona> obtenerPersonas() {
        return  personaRepositorio.findAll();
    }
    public  void crearPersona(Persona persona) {
        personaRepositorio.save(persona);
    }
    public  void elminarPersona(long id) {
        personaRepositorio.deleteById(id);
    }
    public  void actualizarPersona(Persona persona) {
        personaRepositorio.save(persona);
    }
}
