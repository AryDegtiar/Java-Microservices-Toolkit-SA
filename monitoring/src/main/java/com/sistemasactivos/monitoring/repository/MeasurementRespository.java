package com.sistemasactivos.monitoring.repository;

import com.sistemasactivos.monitoring.model.Measurement;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRespository extends BaseRepository<Measurement, Integer> {
}
