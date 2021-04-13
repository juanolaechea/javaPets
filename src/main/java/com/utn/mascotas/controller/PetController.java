package com.utn.mascotas.controller;




import com.utn.mascotas.model.Pet;
import com.utn.mascotas.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/pet")
public class PetController {

    PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public void addPet(@RequestBody Pet newPet){
        petService.addpet(newPet);
    }

    @GetMapping
    List<Pet> getAll(){
        return petService.getAll();
    }
    @GetMapping("/{id}")
    Pet getById(@PathVariable Integer id){
        return petService.getById(id);
    }


}
