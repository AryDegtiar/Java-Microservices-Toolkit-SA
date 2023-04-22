package com.sistemasactivos.monitoring.contreller;

import com.sistemasactivos.monitoring.interfaces.BaseController;
import com.sistemasactivos.monitoring.model.Base;
import com.sistemasactivos.monitoring.model.DataMonitoring;
import com.sistemasactivos.monitoring.service.BaseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl < E extends Base, S extends BaseServiceImpl<E,Integer>> implements BaseController<E,Integer> {

    @Autowired
    protected S service;

    @Override
    @GetMapping(path = {""})
    public ResponseEntity<?> getAllRecords() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> getRecordById(@PathVariable Integer id) throws Exception {
        // valida la existencia del id
        if (!service.existId(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el registro con ese id");

        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

