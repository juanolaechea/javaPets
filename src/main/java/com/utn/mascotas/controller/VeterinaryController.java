package com.utn.mascotas.controller;

import com.utn.mascotas.model.Veterinary;
import com.utn.mascotas.service.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/veterinary")
public class VeterinaryController {

    VeterinaryService veterinaryService;

    @Autowired
    public VeterinaryController(VeterinaryService veterinaryService) {
        this.veterinaryService = veterinaryService;
    }

    @PostMapping
    void addVeterinari(@RequestBody Veterinary newVeterinary){
        veterinaryService.addVeterinary(newVeterinary);

    }
    @GetMapping
    List<Veterinary> getAll(){
        return veterinaryService.getAll();
    }
    @GetMapping("/{id}")
    Veterinary getById(@PathVariable Integer id){
        return veterinaryService.getById(id);
    }

    @PutMapping("/{id}/person/{idPerson}")
    void putPersonInVeterinary(@PathVariable Integer id, @PathVariable Integer idPerson){
        veterinaryService.putPersonInVeterinary(id, idPerson);
    }

}
