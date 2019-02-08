package com.percyvega.experiments.puzzles.pass_by_value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    String myString;
    int myInt;
    Integer myInteger;
    Being myPerson;

    public App() {
        this.initialize();
        this.alter(myString, myInt, myInteger, myPerson);
        this.print(myString, myInt, myInteger, myPerson);
    }

    private void initialize() {
        this.myString = " 1 ";
        this.myInt = 2;
        this.myInteger = new Integer(3);
        this.myPerson = new Person(26, "Percy", "Vega");
    }

    private void alter(String paramString, int paramInt, Integer paramInteger, Being paramPerson) {
        paramString = paramString.trim();
        paramInt = paramInt + 1;
        paramInteger = new Integer(2);
        paramPerson = new Person(33);

        this.print(paramString, paramInt, paramInteger, paramPerson);
    }

    private void print(String paramString, int paramInt, Integer paramInteger, Being paramPerson) {
        logger.debug(paramString + ", " + paramInt + ", " + paramInteger);
        logger.debug(paramPerson.toString());
    }

    public static void main(String args[]) {
        new App();
    }
}
