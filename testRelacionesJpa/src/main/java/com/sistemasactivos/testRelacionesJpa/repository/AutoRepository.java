package com.sistemasactivos.testRelacionesJpa.repository;

import com.sistemasactivos.testRelacionesJpa.model.compartiendoID.Auto;
import com.sistemasactivos.testRelacionesJpa.model.tablaIntermedia.Direccion;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends BaseRepository<Auto, Long>{
    
}
