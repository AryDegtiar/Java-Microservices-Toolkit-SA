package com.sistemasactivos.testRelacionesJpa.model.relacionComun1to1;

import com.sistemasactivos.testRelacionesJpa.model.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pasaporte extends Base {

    @Column
    private String codigo;
    @Column
    private String Nacionalidad;

    @OneToOne(mappedBy = "pasaporte")
    private Persona persona;

    public Pasaporte(String codigo, String Nacionalidad) {
        super();
        this.codigo = codigo;
        this.Nacionalidad = Nacionalidad;
    }

}
