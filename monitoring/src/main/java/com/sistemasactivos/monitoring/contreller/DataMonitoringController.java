package com.sistemasactivos.monitoring.contreller;

import com.sistemasactivos.monitoring.model.DataMonitoring;
import com.sistemasactivos.monitoring.service.DataMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/datamonitoring")
public class DataMonitoringController extends BaseControllerImpl<DataMonitoring, DataMonitoringService> {
    /*  SE COMENTA PORQUE SE HACE LA IMPLEMENTACION AUTOMATICA EN LA CLASE MYSCHEDULEDTASK
    @Autowired
    protected DataMonitoringService service;

    OPCION 1
    @GetMapping(path = {"benefits/CPUused"})
    public ResponseEntity<?> getCPUused() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getBenefitsCPUused());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping(path = {"benefits/MemoryUsed"})
    public ResponseEntity<?> getBenefitsMemoryUsed() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getBenefitsMemoryUsed());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

     */

    /* OPCION 2
    @GetMapping(path = {"benefits/{tipoServicio}"})
    public ResponseEntity<?> getBenefitsMemoryUsed(@PathVariable String tipoServicio) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getBenefits(tipoServicio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
     */

    /* OPCION 3
    @GetMapping(path = {"{microServicio}/{tipoServicio}"})
    public ResponseEntity<?> getMetrics(@PathVariable String microServicio ,@PathVariable String tipoServicio) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getMetrics(microServicio ,tipoServicio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
     */

}