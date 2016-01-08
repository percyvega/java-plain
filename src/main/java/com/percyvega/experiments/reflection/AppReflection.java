package com.percyvega.experiments.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AppReflection {

    private final static Logger logger = LoggerFactory.getLogger(AppReflection.class);

    public static void main(String... args) {

        String[] classNames = new String[]{Integer.class.getName(), List.class.getName(), String.class.getName(), Double.class.getName()};

        AppReflection.classHasMethod("byteValue", classNames);

    }

    private static void classHasMethod(String methodName, String[] classNames) {

        for (String className : classNames) {
            try {
                Class clazz = Class.forName(className);
                clazz.getMethod(methodName);
                logger.debug(className + " has the method " + methodName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                logger.debug(className + " does NOT have the method " + methodName);
                continue;
            }
        }
    }
}