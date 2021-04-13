package com.utn.mascotas.controller;

import com.utn.mascotas.model.Person;
import com.utn.mascotas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/person")
public class PersonController {


    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person newPerson){
        personService.addPerson(newPerson);
    }
    @GetMapping
    public List<Person> getAll(){
        return personService.getAll();
    }

    @GetMapping("/{id}")
    Person getById(@PathVariable Integer id){
        return personService.getById(id);
    }

    @PutMapping ("/{id}/pet/{idPet}")
    void putPetInPerson(@PathVariable Integer id , @PathVariable Integer idPet){
        personService.putPetInPerson(id,idPet);
    }
    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Integer id){
        personService.deleteById(id);
    }


}
