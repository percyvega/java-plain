package com.percyvega.experiments.java8.model.suppliers;

import com.percyvega.experiments.java8.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.percyvega.experiments.java8.model.Constants.FEMALE;
import static com.percyvega.experiments.java8.model.Constants.MALE;

public class StudentsListSupplier {

    public static final Student MATT = new Student("Matt Damon", 2, 3.6, MALE, 10, Arrays.asList("dancing", "basketball", "volleyball"), Optional.empty());
    public static final Student JULIA = new Student("Julia Roberts", 2, 3.5, FEMALE, 11, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.of(MATT));
    public static final Student GEORGE = new Student("George Clooney", 2, 3.8, MALE, 11, Arrays.asList("aerobics", "gymnastics", "soccer"), Optional.empty());
    public static final Student MERYL = new Student("Meryl Streep", 2, 3.3, FEMALE, 10, Arrays.asList("dancing", "basketball", "volleyball"), Optional.of(GEORGE));
    public static final Student JOHNNY = new Student("Johnny Depp", 2, 3.9, MALE, 11, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.of(MERYL));
    public static final Student BEN = new Student("Ben Affleck", 3, 3.0, MALE, 12, Arrays.asList("dancing", "gymnastics", "aerobics"), Optional.of(MERYL));
    public static final Student ELIZABETH = new Student("Elizabeth Taylor", 3, 3.5, FEMALE, 15, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.of(GEORGE));
    public static final Student CLINT = new Student("Clint Eastwood", 3, 3.7, MALE, 12, Arrays.asList("dancing", "gymnastics", "aerobics"), Optional.of(JULIA));
    public static final Student CATE = new Student("Cate Blanchett", 3, 3.9, FEMALE, 15, Arrays.asList("aerobics", "gymnastics", "football"), Optional.of(CLINT));
    public static final Student KEVIN = new Student("Kevin Spacey", 3, 3.3, MALE, 15, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.empty());
    public static final Student EMMA = new Student("Emma Thompson", 3, 4.0, FEMALE, 15, Arrays.asList("swimming", "gymnastics", "soccer"), Optional.of(CLINT));
    public static final Student ROBERT = new Student("Robert De Niro", 4, 3.5, MALE, 10, Arrays.asList("aerobics", "dancing", "football"), Optional.of(EMMA));
    public static final Student JODIE = new Student("Jodie Foster", 4, 3.9, FEMALE, 10, Arrays.asList("swimming", "dancing", "soccer"), Optional.of(ROBERT));
    public static final Student BRAD = new Student("Brad Pitt", 4, 3.5, MALE, 10, Arrays.asList("swimming", "dancing", "football"), Optional.of(JODIE));
    public static final Student SIGOURNEY = new Student("Sigourney Weaver", 4, 3.4, FEMALE, 22, Arrays.asList("aerobics", "basketball", "baseball", "football"), Optional.of(ROBERT));

    public static List<Student> get() {
        List<Student> students = new ArrayList<>();

        students.add(MATT);
        students.add(JULIA);
        students.add(GEORGE);
        students.add(MERYL);
        students.add(JOHNNY);
        students.add(BEN);
        students.add(ELIZABETH);
        students.add(CLINT);
        students.add(CATE);
        students.add(KEVIN);
        students.add(EMMA);
        students.add(ROBERT);
        students.add(JODIE);
        students.add(BRAD);
        students.add(SIGOURNEY);

        return students;
    }

}
