package com.api.sistemasactivos.costumer;

import com.api.sistemasactivos.costumer.model.Costumer;
import com.api.sistemasactivos.costumer.repository.CostumerRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CostumerApplication {

    @Autowired
    CostumerRepository costumerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CostumerApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return (args -> {
            if (args.length > 0) {
                System.out.println("Hello " + args[0]);
            }

            costumerRepository.save(new Costumer(11234423, "nombre", 23, "12-04-1999", "email@gmail.com", "12312313"));
            costumerRepository.save(new Costumer(11122334, "Maria Perez", 25, "1998-07-10", "maria.perez@gmail.com", "12345678"));
            costumerRepository.save(new Costumer(22233445, "Juan Ramirez", 32, "1991-05-25", "juan.ramirez@hotmail.com", "98765432"));
            costumerRepository.save(new Costumer(33344556, "Sofia Martinez", 40, "1983-12-01", "sofia.martinez@yahoo.com", "45678912"));
            costumerRepository.save(new Costumer(44455667, "Luis Fernandez", 28, "1995-02-15", "luis.fernandez@gmail.com", "78901234"));
            costumerRepository.save(new Costumer(55566778, "Ana Rodriguez", 48, "1975-11-23", "ana.rodriguez@hotmail.com", "56789012"));
            costumerRepository.save(new Costumer(66677889, "Pedro Gonzalez", 35, "1988-04-05", "pedro.gonzalez@yahoo.com", "34567890"));
            costumerRepository.save(new Costumer(77789001, "Carla Dominguez", 19, "2004-09-30", "carla.dominguez@gmail.com", "90123456"));
            costumerRepository.save(new Costumer(88890112, "Jose Lopez", 56, "1967-08-12", "jose.lopez@hotmail.com", "23456789"));
            costumerRepository.save(new Costumer(99901223, "Marta Sanchez", 42, "1981-03-18", "marta.sanchez@yahoo.com", "67890123"));
            costumerRepository.save(new Costumer(101112334, "Roberto Jimenez", 30, "1992-10-20", "roberto.jimenez@gmail.com", "01234567"));

            List<Costumer> customers = new ArrayList<>();

            for (int i = 0; i < 10000; i++) {
                String name = "Customer " + i;
                int age = 20 + i;
                String birthDate = "2003-01-" + (i+1);
                String email = "customer" + i + "@example.com";
                String password = "password" + i;

                Costumer customer = new Costumer(i+1, name, age, birthDate, email, password);
                customers.add(customer);
            }

            costumerRepository.saveAll(customers);

        });
    }

}
