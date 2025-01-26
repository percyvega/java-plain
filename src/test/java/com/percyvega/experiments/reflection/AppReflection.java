package com.percyvega.experiments.reflection;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class AppReflection {


    public static void main(String... args) {

        String[] classNames = new String[]{Integer.class.getName(), List.class.getName(), String.class.getName(), Double.class.getName()};

        AppReflection.classHasMethod("byteValue", classNames);

    }

    private static void classHasMethod(String methodName, String[] classNames) {

        for (String className : classNames) {
            try {
                Class clazz = Class.forName(className);
                clazz.getMethod(methodName);
                log.info(className + " has the method " + methodName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                log.info(className + " does NOT have the method " + methodName);
                continue;
            }
        }
    }
}
