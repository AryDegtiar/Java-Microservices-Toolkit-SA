package com.example.tomcat.service;

import com.example.tomcat.model.Benefits;
import com.example.tomcat.model.Costumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class BenefitsService {

    @Autowired
    private WebClient webClient;

    public Flux<Benefits> findAll() {
        return webClient.get()
                .uri("/benefits")
                .retrieve()
                .bodyToFlux(Benefits.class);
    }

}
