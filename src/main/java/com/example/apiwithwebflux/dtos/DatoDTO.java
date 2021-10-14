package com.example.apiwithwebflux.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class DatoDTO {

    private String id;
    @NotBlank(message = "la información no puede estar en blanco")
    @NotNull
    private String informacion;

    public DatoDTO() {

    }

    public DatoDTO(@NotBlank String informacion) {
        this.informacion = informacion;
    }

    public DatoDTO(String id, String informacion) {
        this.id = id;
        this.informacion = informacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatoDTO datoDTO = (DatoDTO) o;
        return Objects.equals(id, datoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DatoDTO{" +
                "id='" + id + '\'' +
                ", informacion='" + informacion + '\'' +
                '}';
    }
}