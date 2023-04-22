package com.api.sistemasactivos.costumer.controller;

import com.api.sistemasactivos.costumer.exception.BusinessException;
import com.api.sistemasactivos.costumer.model.Costumer;
import com.api.sistemasactivos.costumer.service.CostumerServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/costumers")
public class CostumerController extends BaseControllerImpl<Costumer, CostumerServiceImpl> {

    @Autowired
    private CostumerServiceImpl costumerService;

    @Operation(summary = "Obtiene todos los Costumers con un sort, filtrados, paginados", description = "Devuelve todos los Costumers con un sort, filtrados, paginados")
    @Override
    @GetMapping(path = {"/page/search"})
    public ResponseEntity<?> getRecordBy(Pageable pageable, @RequestParam(name = "sort", required = false) String sort,
                                         @RequestParam(name = "keyword", required = true) String keyword) {
        try {
            if (sort != null) {
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
            }
            return ResponseEntity.status(HttpStatus.OK).body(costumerService.search(keyword ,pageable));
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}