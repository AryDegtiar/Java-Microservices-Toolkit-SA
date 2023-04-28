package com.sistemasactivos.testRelacionesJpa.repository;

import com.sistemasactivos.testRelacionesJpa.model.relacionComun1to1.Pasaporte;
import com.sistemasactivos.testRelacionesJpa.model.tablaIntermedia.Direccion;
import org.springframework.stereotype.Repository;

@Repository
public interface PasaporteRepository extends BaseRepository<Pasaporte, Long>{
    
}
