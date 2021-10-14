package com.example.apiwithwebflux.usecases.listarusecase;

import com.example.apiwithwebflux.dtos.DatoDTO;
import com.example.apiwithwebflux.mappers.MapperUtils;
import com.example.apiwithwebflux.models.Dato;
import com.example.apiwithwebflux.repositories.Repositorio;
import com.example.apiwithwebflux.routers.ConsultarDatoRouter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConsultarDatoRouter.class, UseCaseListar.class, MapperUtils.class})
class ConsultarDatoRouterTest {

    @MockBean
    private Repositorio repositorio;

    @Autowired
    private WebTestClient webTestClient;


    @Test
    public void testGetDatos() {
        Dato dato1 = new Dato();
        dato1.setInformacion("Informacion 1");
        Dato dato2 = new Dato();
        dato2.setInformacion("Informacion 2");

        when(repositorio.findAll()).thenReturn(Flux.just(dato1, dato2));

        webTestClient.get()
                .uri("/consultar")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DatoDTO.class)
                .value(userResponse -> {
                            Assertions.assertThat(userResponse.get(0).getInformacion()).isEqualTo(dato1.getInformacion());
                            Assertions.assertThat(userResponse.get(1).getInformacion()).isEqualTo(dato2.getInformacion());
                        }
                );
    }

}