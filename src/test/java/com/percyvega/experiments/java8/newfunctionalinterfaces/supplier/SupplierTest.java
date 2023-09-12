package com.percyvega.experiments.java8.newfunctionalinterfaces.supplier;

import com.percyvega.experiments.java8.model.Student;
import com.percyvega.experiments.java8.model.suppliers.StudentsListSupplier;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SupplierTest {

    public static final Supplier<Student> randomStudentSupplier = () -> StudentsListSupplier.get().get(Math.abs(new Random().nextInt()) % StudentsListSupplier.get().size());

    @Test
    void test_supplier() {
        assertThat(StudentsListSupplier.get()).contains(randomStudentSupplier.get());
    }

}
