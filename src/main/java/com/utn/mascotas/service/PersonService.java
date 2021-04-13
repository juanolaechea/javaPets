package com.utn.mascotas.service;

import com.utn.mascotas.model.Person;
import com.utn.mascotas.model.Pet;
import com.utn.mascotas.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;
    PetService petService;

    @Autowired
    public PersonService(PersonRepository personRepository, PetService petService) {
        this.personRepository = personRepository;
        this.petService = petService;
    }


    public void addPerson(Person newPerson) {
        personRepository.save(newPerson);
    }

    public List<Person> getAll() {
        List<Person> persons = personRepository.findAll();
        if(!persons.isEmpty()){
            return persons;
        }else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

    public Person getById(Integer id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void putPetInPerson(Integer id, Integer idPet) {
        Person person= getById(id);
        Pet pet= petService.getById(idPet);
        person.getPetList().add(pet);
        personRepository.save(person);
    }

    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }
}
