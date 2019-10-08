package com.percyvega.testing.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AssertionTests.class, AnnotationsTest.class, ExceptionsTest.class})
public class SuiteTest {

}