package com.otn.reactive.reactivespringpartI;

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

    public Mono<ServerResponse> getAll(ServerRequest request) {
        // Simulamos un repositorio en memoria creando una lista de clientes.
        List<Cliente> clientesRepositorio = new ArrayList<Cliente>();
        clientesRepositorio.add(new Cliente("1001", "Alberto", "Salazar", 3299999, "Quito, EC170102"));
        clientesRepositorio.add(new Cliente("1002", "Pablo", "Arizaga", 22332233, "Quito, EC170104"));
        clientesRepositorio.add(new Cliente("1003", "Maria", "Valdez", 82923233, "Quito, EC178976"));
        clientesRepositorio.add(new Cliente("1004", "Paola", "Llanos", 87878799, "Quito, EC179087"));
        clientesRepositorio.add(new Cliente("1005", "Tamara", "Cisneros", 4356772, "Quito, EC876590"));

        Flux<Cliente> clientes = Flux.fromIterable(clientesRepositorio);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(clientes, Cliente.class);
    }
}
