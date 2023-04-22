package com.sistemasactivos.monitoring.contreller;

import com.sistemasactivos.monitoring.model.Measurement;
import com.sistemasactivos.monitoring.service.MeasurementService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/measurement")
public class MeasurementController extends BaseControllerImpl<Measurement, MeasurementService> {

}