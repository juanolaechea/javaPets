package com.utn.mascotas.service;

import com.utn.mascotas.model.Person;
import com.utn.mascotas.model.Veterinary;
import com.utn.mascotas.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class VeterinaryService {


    VeterinaryRepository veterinaryRepository;
    PersonService personService;
    @Autowired
    public VeterinaryService(VeterinaryRepository veterinaryRepository, PersonService personService) {
        this.veterinaryRepository = veterinaryRepository;
        this.personService = personService;
    }



    public void addVeterinary(Veterinary newVeterinary) {
        veterinaryRepository.save(newVeterinary);
    }

    public List<Veterinary> getAll() {
        return veterinaryRepository.findAll();
    }

    public Veterinary getById( Integer id) {
        return veterinaryRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

    }

    public void putPersonInVeterinary(Integer id, Integer idPersona) {
        Veterinary vet= getById(id);
        Person persona= personService.getById(idPersona);
        vet.getClientList().add(persona);
        veterinaryRepository.save(vet);
    }
}
