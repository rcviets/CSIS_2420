package a01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class A01Part1Test {

	@Test
	void testEveryOther_null() {
		int[] expected = null;
		int[] array = null;
		int[] actual = A01Part1.everyOther(array);
		assertEquals(expected, actual);
	}
	
	@Test
	void testEveryOther_empty() {
		int[] array = {};
		int[] actual = A01Part1.everyOther(array);
		assertEquals(array, actual);
	}
	
	@Test
	void testEveryOther_singleArray() {
		int[] array = {10};
		int[] actual = A01Part1.everyOther(array);
		assertEquals(array, actual);
	}
	
	@Test
	void testEveryOther_array() {
		int[] expected = {10,30,50};
		int[] array = {10,20,30,40,50,60};
		int[] actual = A01Part1.everyOther(array);
		assertEquals(expected, actual);
	}
	
	@Test
	void testAddSeparators_array() {
		char[] expected = {'7', ',', '6', '5', '4', ',', '3', '2', '1'};
		char[] array = {'7', '6', '5', '4', '3', '2', '1'};
		char[] actual = A01Part1.addSeparators(array);
		assertEquals(expected, actual);
	}

}
