package com.otn.reactive.reactivespringpartI;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ClienteHandler {

    /**
     * GET ALL Customers
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository
        Flux<Cliente> clientes = null;//Flux.fromIterable(customerRepository.findAll());

        // build response
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(clientes, Cliente.class);
    }
}
