package com.sistemasactivos.testRelacionesJpa.repository;

import com.sistemasactivos.testRelacionesJpa.model.compartiendoID.Conductor;
import com.sistemasactivos.testRelacionesJpa.model.tablaIntermedia.Direccion;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends BaseRepository<Conductor, Long>{
    
}
