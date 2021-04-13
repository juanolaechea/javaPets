package com.utn.mascotas.repository;

import com.utn.mascotas.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {
}
