package com.sistemasactivos.testRelacionesJpa;

import com.sistemasactivos.testRelacionesJpa.model.compartiendoID.Auto;
import com.sistemasactivos.testRelacionesJpa.model.compartiendoID.Conductor;
import com.sistemasactivos.testRelacionesJpa.model.relacionComun1to1.Pasaporte;
import com.sistemasactivos.testRelacionesJpa.model.relacionComun1to1.Persona;
import com.sistemasactivos.testRelacionesJpa.model.tablaIntermedia.Direccion;
import com.sistemasactivos.testRelacionesJpa.model.tablaIntermedia.Propietario;
import com.sistemasactivos.testRelacionesJpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestRelacionesJpaApplication {

	@Autowired
	private DireccionRepository direccionRepository;
	@Autowired
	private PropietarioRepository propietarioRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private PasaporteRepository pasaporteRepository;
	@Autowired
	private AutoRepository autoRepository;
	@Autowired
	private ConductorRepository conductorRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestRelacionesJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return (args -> {
			if (args.length > 0) {
				System.out.println("Hello " + args[0]);
			}
			System.out.println("TestRelacionesJpaApplication.testRelaciones()");

			// - - - Test de relaciones - - -

			// Relacion 1 a 1 con tabla intermedia
			Direccion direccion = new Direccion("Calle 1", "1", "Municipio 1", "Pais 1", "12345");
			direccion =  direccionRepository.save(direccion);
			Propietario propietarioConDireccion = new Propietario("Nombre 1", "Apellido 1", "123456789");
			propietarioConDireccion.setDireccion(direccion);
			propietarioRepository.save(propietarioConDireccion);

			Propietario propietarioSinDireccion = new Propietario("Nombre 2", "Apellido 2", "987654321");
			propietarioRepository.save(propietarioSinDireccion);

			// Relacion 1 a 1 compartiendo id
			Conductor conductor = new Conductor("Nombre 3", "Apellido 3", "Tipo 1", "123456789");
			Auto auto = new Auto("Marca 1", "Modelo 1", "Color 1");
			auto.setConductor(conductor);
			conductor.setAuto(auto);
			conductorRepository.save(conductor);

			// Relacion 1 a 1 comun
			Pasaporte pasaporte = new Pasaporte("123456789", "Nacionalidad 1");
			Persona persona = new Persona("Nombre 4", "Apellido 4", 23, pasaporte);
			personaRepository.save(persona);

		});

	}

}
