package com.udea.api.services;

import com.udea.api.model.Persona;
import com.udea.api.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired //indica que esta conectado al repositorio y usa este mismo con sus objetos
    private PersonaRepository personaRepository;

    public Persona create(Persona persona){
        return personaRepository.save(persona);
    }
    public List<Persona> listar(){
        return personaRepository.findAll();
    }

    public void delete(Persona persona){

         personaRepository.delete(persona);
    }
    public Optional<Persona> finById(Integer id){
        return personaRepository.findById(id);
    }

}
