package com.example.apiwithwebflux.usecases.creardatousecase;

import com.example.apiwithwebflux.dtos.DatoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarDato {
    public Mono<String> apply(DatoDTO datoDTO);
}