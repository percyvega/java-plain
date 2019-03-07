package com.percyvega.experiments.initializations.constructors;

public class Deer {

    private int age;
    private boolean hasHorns;

    public Deer() {
        System.out.println("Calling public Deer()");
    }

    public Deer(int age) {
        setAge(age);
        System.out.println("Calling public Deer(int lastName)");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean hasHorns() {
        System.out.println("Calling Deer's public boolean hasHorns()");
        return hasHorns;
    }

    public void setHasHorns(boolean hasHorns) {
        this.hasHorns = hasHorns;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "lastName=" + age +
                ", hasHorns=" + hasHorns +
                '}';
    }
}
