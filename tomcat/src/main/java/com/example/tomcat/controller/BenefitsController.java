package com.example.tomcat.controller;

import com.example.tomcat.model.Benefits;
import com.example.tomcat.model.Costumer;
import com.example.tomcat.service.BenefitsService;
import com.example.tomcat.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class BenefitsController {

    @Autowired
    private BenefitsService benefitsService;

    @GetMapping("/benefits")
    public String getCustomers(Model model) {
        Flux<Benefits> benefits = benefitsService.findAll();
        model.addAttribute("benefits", benefits.collectList().block());
        return "benefits";
    }

    @GetMapping("/benefitsv2")
    public Mono<String> getCustomersv2(Model model) {
        Flux<Benefits> benefits = benefitsService.findAll();
        Mono<List<Benefits>> benefitsListMono = benefits.collectList();
        return benefitsListMono.map(benefitsList -> {
            model.addAttribute("benefits", benefitsList);
            return "benefits";
        });
    }

}
