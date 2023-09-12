package com.percyvega.experiments.java8.repeatingannotations.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// to get the annotation information at runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface Colors {
    Color[] value();
}
