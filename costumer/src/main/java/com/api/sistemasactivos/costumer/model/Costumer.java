package com.api.sistemasactivos.costumer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "costumers")
public class Costumer extends Base {
    @NotNull(message = "El dni no puede estar vacío")
    private Integer dni;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String firstName;
    @NotNull(message = "La edad no puede estar vacía")
    private Integer age;
    @NotBlank(message = "La fecha de nacimiento no puede estar vacía")
    private String datebirth;
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email no es válido")
    private String email;
    @NotBlank(message = "El teléfono no puede estar vacío")
    private String phone;

    private Date createdAt;
    private Date updatedAt;

    public Costumer() {
        super();
        // esta comentado por que ya el otro constructor lo hace, esta explicado en el mail
        //this.createdAt = new Date();
        //this.updatedAt = new Date();
    }

    public Costumer(Integer dni, String firstName, Integer age, String datebirth, String email, String phone) {
        super();
        this.dni = dni;
        this.firstName = firstName;
        this.age = age;
        this.datebirth = datebirth;
        this.email = email;
        this.phone = phone;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    public void actualizarCostumer(Costumer costumer) {
        this.dni = costumer.dni;
        this.firstName = costumer.firstName;
        this.age = costumer.age;
        this.datebirth = costumer.datebirth;
        this.email = costumer.email;
        this.phone = costumer.phone;
        this.updatedAt = new Date();
    }


}
