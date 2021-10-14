package com.example.apiwithwebflux.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Document
public class Dato {
    @Id
    private String id;
    @NotBlank
    private String informacion;
}