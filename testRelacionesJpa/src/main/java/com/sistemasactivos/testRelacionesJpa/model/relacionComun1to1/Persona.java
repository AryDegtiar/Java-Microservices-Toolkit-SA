package com.sistemasactivos.testRelacionesJpa.model.relacionComun1to1;

import com.sistemasactivos.testRelacionesJpa.model.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona extends Base {

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Integer edad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasaporte_id", referencedColumnName = "id")
    private Pasaporte pasaporte;

    public Persona(String nombre, String apellido, Integer edad) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    
}
