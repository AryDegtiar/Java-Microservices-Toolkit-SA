package com.sistemasactivos.benefits.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "benefits")
public class Benefits extends Base {
    @NotNull(message = "El numBeneficio no puede estar vacío")
    private Integer numBeneficio;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La descripcion no puede estar vacío")
    private String descripcion;
    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;

}
