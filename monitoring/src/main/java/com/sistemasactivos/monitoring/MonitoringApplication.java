package com.sistemasactivos.monitoring;

import com.sistemasactivos.monitoring.model.DataMonitoring;
import com.sistemasactivos.monitoring.model.Measurement;
import com.sistemasactivos.monitoring.repository.DataMonitoringRepository;
import com.sistemasactivos.monitoring.repository.MeasurementRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MonitoringApplication {

	@Autowired
	private DataMonitoringRepository dataMonitoringRepository;
	@Autowired
	private MeasurementRespository measurementRespository;

	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			if (args.length > 0) {
				System.out.println("Hello " + args[0]);
			}
/*
			Measurement measurement = new Measurement("CPU", "80", new Date());
			measurementRespository.save(measurement);
			List<Measurement> measurementList= new ArrayList<>();
			measurementList.add(measurement);
			dataMonitoringRepository.save(new DataMonitoring("localhost:8085/api/v1/tuviejaentanga","system CPU", "The \\\"recent cpu usage\\\" of the system the application is running in", "", measurementList));
*/
		};
	}
}
