package com.sistemasactivos.monitoring.service;

import com.sistemasactivos.monitoring.config.WebClientConfig;
import com.sistemasactivos.monitoring.model.DataMonitoring;
import com.sistemasactivos.monitoring.model.Measurement;
import com.sistemasactivos.monitoring.repository.BaseRepository;
import com.sistemasactivos.monitoring.repository.DataMonitoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class DataMonitoringService extends BaseServiceImpl<DataMonitoring, Integer>{
    @Autowired
    @Qualifier("webClientBenefits")
    WebClient webClientBenefits;

    @Autowired
    @Qualifier("webClientCostumer")
    WebClient webClientCostumers;

    @Autowired
    @Qualifier("webClientMonitoring")
    WebClient webClientMonitoring;

    public DataMonitoringService(BaseRepository<DataMonitoring, Integer> baseRepository) {
        super(baseRepository);
    }

    /* OPCION 1
    public DataMonitoring getBenefitsCPUused() throws Exception {
        return getBenefits("/system.cpu.usage");
    }

    public DataMonitoring getBenefitsMemoryUsed() throws Exception {
        return getBenefits("/jvm.memory.used");
    }

    private DataMonitoring getBenefits(String servicio) throws Exception {
        DataMonitoring dataMonitoring = webClientBenefits.get()
                .uri(servicio)
                .retrieve()
                .bodyToMono(DataMonitoring.class).block();

        // Agregar fecha a cada medida
        List<Measurement> measurements = dataMonitoring.getMeasurements();
        Date date = new Date();
        for (Measurement measurement : measurements) {
            measurement.setDate(date);
        }

        dataMonitoring.setService("MS-Benefits");
        return this.save(dataMonitoring);
    }
    */

    /* OPCION 2
    public DataMonitoring getBenefits(String tipoServicio) throws Exception {
        DataMonitoring dataMonitoring = webClientBenefits.get()
                .uri("/"+tipoServicio)
                .retrieve()
                .bodyToMono(DataMonitoring.class).block();

        // Agregar fecha a cada medida
        List<Measurement> measurements = dataMonitoring.getMeasurements();
        Date date = new Date();
        for (Measurement measurement : measurements) {
            measurement.setDate(date);
        }

        dataMonitoring.setService("MS-Benefits");
        return this.save(dataMonitoring);
    }
     */



    // OPCION 3
    public DataMonitoring getMetrics(String microServicio ,String tipoServicio) throws Exception {
        DataMonitoring dataMonitoring = this.getWebClient(microServicio).get()
                .uri("/"+tipoServicio)
                .retrieve()
                .bodyToMono(DataMonitoring.class).block();

        // Agregar fecha a cada medida
        List<Measurement> measurements = dataMonitoring.getMeasurements();
        Date date = new Date();
        for (Measurement measurement : measurements) {
            measurement.setDate(date);
        }

        dataMonitoring.setService("MS-"+microServicio);
        return this.save(dataMonitoring);
    }

    public WebClient getWebClient(String microServicio) throws Exception {
        switch (microServicio) {
            case "benefits":
                return webClientBenefits;
            case "costumers":
                return webClientCostumers;
            case "monitoring":
                return webClientMonitoring;
            default:
                throw new Exception("Microservicio no encontrado");
        }
    }


}
