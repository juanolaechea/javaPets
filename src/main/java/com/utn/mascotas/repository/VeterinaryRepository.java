package com.utn.mascotas.repository;

import com.utn.mascotas.model.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRepository extends JpaRepository<Veterinary,Integer> {
}
