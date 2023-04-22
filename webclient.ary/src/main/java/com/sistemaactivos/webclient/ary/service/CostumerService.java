package com.sistemaactivos.webclient.ary.service;

import com.sistemaactivos.webclient.ary.model.Costumer;
import com.sistemaactivos.webclient.ary.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class CostumerService implements ICostumerService {

    @Autowired
    WebClient webClientCostumer;

    @Override
    public Flux<Costumer> findAll() {
        return webClientCostumer.get()
                .uri("/costumers")
                .retrieve()
                .bodyToFlux(Costumer.class)
                .timeout(Duration.ofMillis(10_000));
    }

    @Override
    public Mono<Costumer> findByID(Integer id) {
        return webClientCostumer.get()
                .uri("/costumers/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(),
                        response -> response.bodyToMono(ErrorResponse.class)
                                .flatMap(errorResponse -> Mono.error(
                                        new RuntimeException(errorResponse.getStatus() + ": " + errorResponse.getMessage()))))
                .bodyToMono(Costumer.class)
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontró el recurso")));
    }

    @Override
    public Flux<Costumer> getCostumers(int pageSize, int pageNumber) {
        int offset = pageSize * pageNumber;
        return webClientCostumer.get()
                .uri("/costumers?page={pageNumber}&size={pageSize}", pageNumber, pageSize)
                .retrieve()
                .bodyToFlux(Costumer.class)
                .skip(offset)
                .take(pageSize);
    }

    @Override
    public Mono<Costumer> create(Costumer costumer) {
        return webClientCostumer.post()
                .uri("/costumers")
                .body(Mono.just(costumer), Costumer.class)
                .retrieve()
                .onStatus(status -> status.isError(), response -> response.bodyToMono(ErrorResponse.class)
                        .flatMap(errorResponse -> Mono.error(new RuntimeException(errorResponse.getStatus() + ": " + errorResponse.getMessage()))))
                .bodyToMono(Costumer.class)
                .timeout(Duration.ofMillis(10000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontró el recurso")));
    }

    @Override
    public Mono<Costumer> update(Integer id, Costumer costumer) {
        return webClientCostumer.put()
                .uri("/costumers/{id}", id)
                .body(Mono.just(costumer), Costumer.class)
                .retrieve()
                .onStatus(status -> status.isError(), response -> response.bodyToMono(ErrorResponse.class)
                        .flatMap(errorResponse -> Mono.error(new RuntimeException(errorResponse.getStatus() + ": " + errorResponse.getMessage()))))
                .bodyToMono(Costumer.class)
                .timeout(Duration.ofMillis(10000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontró el recurso")));
    }

    @Override
    public Mono<Boolean> delete(Integer id) {
        return webClientCostumer.delete()
                .uri("/costumers/{id}", id)
                .retrieve()
                .onStatus(status -> status.isError(), response -> response.bodyToMono(ErrorResponse.class)
                        .flatMap(errorResponse -> Mono.error(new RuntimeException(errorResponse.getStatus() + ": " + errorResponse.getMessage()))))
                .bodyToMono(Boolean.class)
                .timeout(Duration.ofMillis(10000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontró el recurso")));
    }

}
