package com.example.tomcat.controller;

import com.example.tomcat.model.Costumer;
import com.example.tomcat.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @GetMapping("/hola")
    public String hello(Model model) {
        model.addAttribute("mensaje", "This is a message");
        return "hola";
    }

    @GetMapping("/costumers")
    public String getCustomers(Model model) {
        Flux<Costumer> customers = costumerService.findAll();
        model.addAttribute("costumers", customers.collectList().block());
        return "costumers";
    }

    @GetMapping("/costumersv2")
    public Mono<String> getCustomersv2(Model model) {
        Flux<Costumer> customers = costumerService.findAll();
        Mono<List<Costumer>> customersListMono = customers.collectList();
        return customersListMono.map(customersList -> {
            model.addAttribute("costumers", customersList);
            return "costumers";
        });
    }

}
