package com.sistemasactivos.benefits;

import com.sistemasactivos.benefits.model.Benefits;
import com.sistemasactivos.benefits.repository.BenefitsRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BenefitsApplication {

	@Autowired
	BenefitsRepository benefitsRepository;

	public static void main(String[] args) {
		SpringApplication.run(BenefitsApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			if (args.length > 0) {
				System.out.println("Hello " + args[0]);
			}

			benefitsRepository.save(new Benefits(1, "nombre", "descripcion", "tipo"));
			benefitsRepository.save(new Benefits(1, "Seguro médico", "Cobertura médica para el empleado y su familia", "Salud"));
			benefitsRepository.save(new Benefits(2, "Vacaciones pagadas", "Días libres con salario completo", "Tiempo libre"));
			benefitsRepository.save(new Benefits(3, "Plan de retiro", "Opciones de ahorro para la jubilación", "Financiero"));
			benefitsRepository.save(new Benefits(4, "Días de enfermedad", "Días libres pagados en caso de enfermedad", "Salud"));
			benefitsRepository.save(new Benefits(5, "Seguro dental", "Cobertura dental para el empleado y su familia", "Salud"));
			benefitsRepository.save(new Benefits(6, "Bonos de desempeño", "Incentivos monetarios por un buen desempeño", "Financiero"));
			benefitsRepository.save(new Benefits(7, "Horario flexible", "Posibilidad de modificar el horario laboral", "Tiempo libre"));
			benefitsRepository.save(new Benefits(8, "Descuentos en gimnasios", "Tarifas especiales en gimnasios afiliados", "Salud"));
			benefitsRepository.save(new Benefits(9, "Seguro de vida", "Protección financiera en caso de fallecimiento", "Financiero"));
			benefitsRepository.save(new Benefits(10, "Asistencia para cuidado infantil", "Apoyo para el cuidado de hijos menores de edad", "Familiar"));
		};
	}

}
