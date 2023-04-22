package com.sistemasactivos.benefits.controller;

import com.sistemasactivos.benefits.exception.BusinessException;
import com.sistemasactivos.benefits.model.Benefits;
import com.sistemasactivos.benefits.service.BenefitsServiceImpl;
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
@RequestMapping(path = "/api/v1/benefits")
public class BenefitsController extends BaseControllerImpl<Benefits, BenefitsServiceImpl> {

}