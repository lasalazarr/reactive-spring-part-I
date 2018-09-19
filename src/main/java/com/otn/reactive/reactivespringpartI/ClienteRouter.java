package com.otn.reactive.reactivespringpartI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
@CrossOrigin
public class ClienteRouter {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(ClienteHandler clienteHandler){
        return route(GET("/reactive/v1/cliente").and(accept(MediaType.APPLICATION_JSON)), clienteHandler::getAll);
    }
}
