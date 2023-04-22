package com.example.tomcat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Benefits {
    private Integer id;
    private Integer numBeneficio;
    private String nombre;
    private String descripcion;
    private String tipo;

}
