package com.sistemasactivos.testRelacionesJpa.model.compartiendoID;

import com.sistemasactivos.testRelacionesJpa.model.Base;
import com.sistemasactivos.testRelacionesJpa.model.compartiendoID.Auto;
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
public class Conductor extends Base {

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String tipoLicencia;
    @Column
    private String numeroLicencia;

    @OneToOne(mappedBy = "conductor", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn // indica que el id de la clase es el mismo que el de la clase a la que se hace referencia
    private Auto auto;

    public Conductor(String nombre, String apellido, String tipoLicencia, String numeroLicencia) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoLicencia = tipoLicencia;
        this.numeroLicencia = numeroLicencia;
        this.auto = null;
    }

}
