package com.example.apiwithwebflux.repositories;

import com.example.apiwithwebflux.models.Dato;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repositorio extends ReactiveMongoRepository<Dato, String> {
}
