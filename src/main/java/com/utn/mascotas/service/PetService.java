package com.utn.mascotas.service;

import com.utn.mascotas.model.Pet;
import com.utn.mascotas.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PetService {

    PetRepository petRepository;
    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void addpet(Pet newPet) {
        petRepository.save(newPet);
    }

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public Pet getById(Integer id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
}
