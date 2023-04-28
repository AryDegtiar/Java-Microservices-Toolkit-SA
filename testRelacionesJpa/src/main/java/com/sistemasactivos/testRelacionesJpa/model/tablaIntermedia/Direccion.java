package com.sistemasactivos.testRelacionesJpa.model.tablaIntermedia;

import com.sistemasactivos.testRelacionesJpa.model.Base;
import com.sistemasactivos.testRelacionesJpa.model.tablaIntermedia.Propietario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Direccion extends Base {

    @Column(name = "calle", length = 50, nullable = false)
    private String calle;
    @Column(name = "numero", length = 10, nullable = false)
    private String numero;
    @Column(name = "colonia", length = 50, nullable = false)
    private String municipio;
    @Column(name = "ciudad", length = 50, nullable = false)
    private String pais;
    @Column(name = "cp", length = 10, nullable = false)
    private String cp;

    @OneToOne(mappedBy = "direccion")
    private Propietario propietario;

    public Direccion(String calle, String numero, String municipio, String pais, String cp) {
        super();
        this.calle = calle;
        this.numero = numero;
        this.municipio = municipio;
        this.pais = pais;
        this.cp = cp;
    }

}
