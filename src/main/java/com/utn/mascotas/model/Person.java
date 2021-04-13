package com.utn.mascotas.model;

import ch.qos.logback.core.rolling.helper.PeriodicityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "El campo nombre es obligatorio.")
    private String name;
    @NotNull(message = "El campo apellido es obligatorio.")
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "petId")
    private List<Pet> petList;


}
