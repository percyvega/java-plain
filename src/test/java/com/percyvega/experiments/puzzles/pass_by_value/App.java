package com.percyvega.experiments.puzzles.pass_by_value;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {


    String myString;
    int myInt;
    Integer myInteger;
    Being myPerson;

    public App() {
        this.initialize();
        this.alter(myString, myInt, myInteger, myPerson);
        this.print(myString, myInt, myInteger, myPerson);
    }

    public static void main(String[] args) {
        new App();
    }

    private void initialize() {
        this.myString = " 1 ";
        this.myInt = 2;
        this.myInteger = 3;
        this.myPerson = new Person(26, "Percy", "Vega");
    }

    private void alter(String paramString, int paramInt, Integer paramInteger, Being paramPerson) {
        paramString = paramString.trim();
        paramInt = paramInt + 1;
        paramInteger = 2;
        paramPerson = new Person(33);

        this.print(paramString, paramInt, paramInteger, paramPerson);
    }

    private void print(String paramString, int paramInt, Integer paramInteger, Being paramPerson) {
        log.debug(paramString + ", " + paramInt + ", " + paramInteger);
        log.debug(paramPerson.toString());
    }
}
