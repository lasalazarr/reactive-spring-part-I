package com.otn.reactive.reactivespringpartI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteHandler {

    @Autowired
    MockClienteRepository mockClienteRepository;

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<Cliente> clientes = Flux.fromIterable(mockClienteRepository.getAll());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(clientes, Cliente.class);
    }


}
