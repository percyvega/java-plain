package com.percyvega.experiments.java8.repeatingannotations.model;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// to get the annotation information at runtime
@Retention(RetentionPolicy.RUNTIME)
// to enable the repeated use of this annotation
@Repeatable(Colors.class)
public @interface Color {
    String name();
}
