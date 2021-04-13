package com.utn.mascotas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Veterinary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull (message = "El campo nombre es obligatorio.")
    private String name;
    @NotNull (message = "El campo apellido es obligatorio.")
    private String lastName;
    @Positive (message = "El campo matricula es positivo.")
    private Integer matricula;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private List<Person>clientList;



}
