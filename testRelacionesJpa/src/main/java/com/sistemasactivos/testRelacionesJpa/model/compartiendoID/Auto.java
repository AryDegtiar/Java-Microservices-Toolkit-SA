package com.sistemasactivos.testRelacionesJpa.model.compartiendoID;

import com.sistemasactivos.testRelacionesJpa.model.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Auto extends Base {

    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String color;

    @OneToOne
    @MapsId // indica que el id de la clase es el mismo que el de la clase a la que se hace referencia
    @JoinColumn(name = "conductor_id", referencedColumnName = "id")
    private Conductor conductor;

    public Auto(String marca, String modelo, String color) {
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.conductor = null;
    }
}
