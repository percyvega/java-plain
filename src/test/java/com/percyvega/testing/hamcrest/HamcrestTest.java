package com.percyvega.testing.hamcrest;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestTest {

	String[] myArray = {"4", "5", "2"};
	List<String> myList = new ArrayList<>(Arrays.asList(myArray));
	Map<String, Integer> countryPopMill = new HashMap<String, Integer>() {{
		put("China", 1367);
		put("India", 1251);
		put("US", 321);
	}};

	Date myDate = new Date();
	Date sameInstanceAsMyDate = myDate;
	Date anotherDate = (Date) myDate.clone();
	Date yetAnotherDate;

	/* Core */
	@Test
	public void testHamcrestCore() {
		// is
		assertThat(4 + 2, is(3 + 3));
		// anything
		assertThat("Hello", is(anything()));
	}

	/* Logical */
	@Test
	public void testHamcrestLogical() {
		// allOf
		assertThat("Hello", allOf(notNullValue(), instanceOf(String.class), equalTo("Hello")));
		// anyOf
//		assertThat(myList, anyOf(hasItem("5"), hasItem("10"), hasItem("1")));
		// not
		assertThat(6 * 2, not(4 * 5));
	}

	/* Object */
	@Test
	public void testHamcrestObject() {
		// equalTo
		assertThat(myDate, allOf(equalTo(sameInstanceAsMyDate), equalTo(anotherDate)));
		// instanceOf
		assertThat(myList, allOf(instanceOf(ArrayList.class), instanceOf(List.class)));
		// isA
		assertThat(myList, isA(List.class));
		assertThat(myDate, isA(Date.class));
		// notNullValue
		assertThat(myDate, notNullValue());
		// nullValue
		assertThat(yetAnotherDate, nullValue());
		// sameInstance
		assertThat(myDate, allOf(sameInstance(sameInstanceAsMyDate), not(sameInstance(anotherDate))));
	}

	/* Arrays */
	@Test
	public void testHamcrestArrays() {
		// isIn - also for collections
		assertThat("5", isIn(myArray));
		// isOneOf
		assertThat("4", isOneOf(myArray));
		// hasItemInArray
		assertThat(myArray, hasItemInArray("5"));
		// arrayContaining
		assertThat(myArray, arrayContaining("4", "5", "2"));
		// arrayContainingInAnyOrder
		assertThat(myArray, arrayContainingInAnyOrder("2", "5", "4"));
		// arrayWithSize
		assertThat(myArray, arrayWithSize(3));
		// emptyArray
		assertThat(myArray, not(emptyArray()));
	}

	/* Collections */
	@Test
	public void testHamcrestCollections() {
		// isIn - also for arrays
		assertThat("5", isIn(myList));
		// hasEntry
		assertThat(countryPopMill, hasEntry("China", 1367));
		assertThat(countryPopMill, hasKey("China"));
		assertThat(countryPopMill, hasValue(1367));
		// hasItem
		assertThat(myList, hasItem("2"));
		assertThat(myList, hasItems("5", "4"));
		// contains
		assertThat(myList, contains("4", "5", "2"));
		assertThat(myList, containsInAnyOrder("2", "5", "4"));
		// hasSize
		assertThat(myList, hasSize(3));
		// empty
		assertThat(myList, not(empty()));
	}

	/* Number */
	@Test
	public void testHamcrestNumber() {
		// closeTo
		assertThat(1f / 3, is(.33333334f));
		assertThat(1f / 3, is(not(.33333334)));
		assertThat(1f / 3, is(not(.33333f)));
		// closeTo
		final double MAX_MARGIN_ERROR = 0.004;
		assertThat(1d / 3, closeTo(.33, MAX_MARGIN_ERROR));
		// greaterThan
		assertThat(1f / 3, greaterThan(0.33f));
		// greaterThanOrEqualTo
		assertThat(1f / 3, greaterThanOrEqualTo(.33333334f));
		// lessThan
		assertThat(1f / 3, lessThan(0.34f));
		// lessThanOrEqualTo
		assertThat(1f / 3, lessThanOrEqualTo(.33333334f));
	}

	/* Text */
	@Test
	public void testHamcrestText() {
		assertThat("Hello World!", is(equalTo("Hello World!")));
		assertThat("Hello World!", is(equalToIgnoringCase("HELLO world!")));
		assertThat("Hello World!", is(not(isEmptyOrNullString())));
		assertThat("Hello World!", is(stringContainsInOrder(Arrays.asList("Hello ", "World", "!"))));
		assertThat("Hello World!", is(equalToIgnoringWhiteSpace("	Hello   World!   ")));
		assertThat("Hello World!", is(containsString("World")));
		assertThat("Hello World!", is(startsWith("Hello")));
		assertThat("Hello World!", is(endsWith("World!")));
	}

}
