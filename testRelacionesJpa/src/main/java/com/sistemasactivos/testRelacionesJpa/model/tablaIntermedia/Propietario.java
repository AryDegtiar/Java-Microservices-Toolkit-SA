package com.sistemasactivos.testRelacionesJpa.model.tablaIntermedia;

import com.sistemasactivos.testRelacionesJpa.model.Base;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Propietario extends Base {

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String telefono;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinTable(name = "propietario_direccion",
        joinColumns = @JoinColumn(name = "propietario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "direccion_id", referencedColumnName = "id"))
    private Direccion direccion;

    public Propietario(String nombre, String apellido, String telefono) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = null;
    }

    public Propietario(String nombre, String apellido, String telefono, Direccion direccion) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

}
