package com.percyvega.experiments.hashcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data // this creates a hashCode, making this class return a consistent/repeatable hashCode
@AllArgsConstructor
public class Pet {
    private String name;
    private LocalDate birthday;
}
