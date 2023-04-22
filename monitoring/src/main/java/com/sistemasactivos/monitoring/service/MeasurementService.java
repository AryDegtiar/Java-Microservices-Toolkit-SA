package com.sistemasactivos.monitoring.service;

import com.sistemasactivos.monitoring.model.Measurement;
import com.sistemasactivos.monitoring.repository.BaseRepository;
import org.springframework.stereotype.Service;


@Service
public class MeasurementService extends BaseServiceImpl<Measurement, Integer> {

    public MeasurementService(BaseRepository<Measurement, Integer> baseRepository) {
        super(baseRepository);
    }
}