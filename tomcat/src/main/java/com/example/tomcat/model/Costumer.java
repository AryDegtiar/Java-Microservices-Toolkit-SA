package com.example.tomcat.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Costumer {
    Integer id;

    Integer dni;
    String firstName;
    Integer age;
    String datebirth;
    String email;
    String phone;

    public Costumer() {
    }

    public Costumer(Integer id, Integer dni, String firstName, Integer age, String datebirth, String email, String phone) {
        super();
        this.id = id;
        this.dni = dni;
        this.firstName = firstName;
        this.age = age;
        this.datebirth = datebirth;
        this.email = email;
        this.phone = phone;
    }
}
