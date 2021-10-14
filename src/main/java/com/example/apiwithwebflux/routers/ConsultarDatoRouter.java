package com.example.apiwithwebflux.routers;

import com.example.apiwithwebflux.dtos.DatoDTO;
import com.example.apiwithwebflux.usecases.listarusecase.UseCaseListar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ConsultarDatoRouter {
    @Bean
    public RouterFunction<ServerResponse> getAll(UseCaseListar useCaseListar) {
        return route(
                GET("/consultar").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseListar.get(), DatoDTO.class))
        );
    }


}