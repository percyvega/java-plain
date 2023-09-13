package com.percyvega.experiments.generics;

import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FullExample {

    @Test
    void testFull() {
        List<LivingBeing> livingBeings = new ArrayList<>(List.of(
                new LivingBeing(5),
                new LivingBeing(25)
        ));
        addCats(livingBeings);
        print(livingBeings);

        List<Animal> animals = new ArrayList<>(List.of(
                new Animal(5, "animal1"),
                new Animal(15, "animal2")
        ));
        addCats(animals);
        print(animals);

        List<Cat> cats = new ArrayList<>(List.of(
                new Cat(5, "animal1", true),
                new Cat(15, "animal2", false)
        ));
//        addCats(cats); // does NOT compile
        print(cats);
    }

    public static void print(List<? extends LivingBeing> livingBeings) {
        livingBeings.forEach(System.out::println);
    }

    public static void addCats(List<? super Animal> animals) {
        animals.add(new Cat(4, "Fido", true));
        animals.add(new Cat(14, "Dofi", false));
    }
}

@Getter
class LivingBeing {

    public int age;

    public LivingBeing(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "LivingBeing{" +
                "age=" + age +
                '}';
    }
}

@Getter
class Animal extends LivingBeing {
    public String name;

    public Animal(int age, String name) {
        super(age);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@Getter
class Cat extends Animal {
    public boolean domesticated;

    public void setDomesticated(boolean domesticated) {
        this.domesticated = domesticated;
    }

    public Cat(int age, String name, boolean domesticated) {
        super(age, name);
        this.domesticated = domesticated;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "domesticated=" + domesticated +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
