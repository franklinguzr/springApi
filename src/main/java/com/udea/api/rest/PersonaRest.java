package com.udea.api.rest;

import com.udea.api.model.Persona;
import com.udea.api.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona/")
public class PersonaRest {
    @Autowired
    private PersonaService personaService;

    @PostMapping
    private ResponseEntity<Persona> guardar(@RequestBody Persona persona){
    Persona Temporal = personaService.create(persona);
    try{
    return ResponseEntity.created(new URI("api/persona"+Temporal.getId())).body(Temporal);
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    }
    @GetMapping
    private ResponseEntity<List<Persona>> listar(){
        return ResponseEntity.ok(personaService.listar());
    }
    @DeleteMapping
    private ResponseEntity<Void> eliminar(@RequestBody Persona persona){
         personaService.delete(persona);
         return ResponseEntity.ok().build();
    }
    @GetMapping(value = "{id}")
    private ResponseEntity<Optional<Persona>> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(personaService.finById(id));
    }

}
