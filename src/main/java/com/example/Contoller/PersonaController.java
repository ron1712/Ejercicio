package com.example.Contoller;

import com.example.Entidades.Persona;
import com.example.Servicios.PersonaServicio;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "personas")
public class PersonaController {
    @Autowired
    private final PersonaServicio personaServicio;
    public PersonaController(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }
    @GetMapping
    public List<Persona> listarPersonas() {
        return personaServicio.obtenerPersonas();
    }

    @PostMapping
    public void guardarPersonas(@RequestBody Persona persona) {
        personaServicio.crearPersona(persona);
    }

    @PostUpdate
    public void actualizarPersonas(@RequestBody Persona persona) {
        personaServicio.actualizarPersona(persona);
    }

    @DeleteMapping("/{idPersona}")
    public void eliminarPersonas(@PathVariable("idPersona") long  idPersona) {
        personaServicio.elminarPersona(idPersona);
    }
}
