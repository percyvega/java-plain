package com.percyvega.experiments.java8.model.suppliers;

import com.percyvega.experiments.java8.model.Student;

import java.util.List;

public class StudentsWithNullListSupplier {

    public static List<Student> get() {
        List<Student> students = StudentsListSupplier.get();
        students.add(null);

        return students;
    }

}
