package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Subject {

    @JsonProperty("id")
    private Integer id; // Identyfikator przedmiotu

    @JsonProperty("nazwa")
    private String nazwa; // Nazwa przedmiotu

    @JsonProperty("ects")
    private Integer ects; // Liczba punktów ECTS

    @JsonProperty("sala")
    private String sala; // Numer sali, w której odbywają się zajęcia

    @JsonProperty("egzamin")
    private boolean egzamin; // Informacja, czy przedmiot kończy się egzaminem

    public boolean getEgzamin() {
        return egzamin;
    }
}