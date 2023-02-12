package ceLinearBinary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	void testLinear_firstElement() {
		int expected = 0;
		int[] array = new int []{1,2,3,4,5};
		int actual = Search.linear(array, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLinear_middleElement() {
		int expected = 2;
		int[] array = new int []{1,2,3,4,5};
		int actual = Search.linear(array, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLinear_lastElement() {
		int expected = 4;
		int[] array = new int []{1,2,3,4,5};
		int actual = Search.linear(array, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLinear_elementNotInArray() {
		int expected = -1;
		int[] array = new int []{1,2,3,4,5};
		int actual = Search.linear(array, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testLinear_emptyArray() {
		int expected = -1;
		int[] array = new int [4];
		int actual = Search.linear(array, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBinary_firstElement() {
		int expected = 0;
		int[] array = new int []{1,2,3,4,5};
		int actual = Search.binary(array, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBinary_middleElement() {
		int expected = 2;
		int[] array = new int []{1,2,3,4,5};
		int actual = Search.binary(array, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBinary_lastElement() {
		int expected = 4;
		int[] array = new int []{1,2,3,4,5};
		int actual = Search.binary(array, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBinary_elementNotInArray() {
		int expected = -1;
		int[] array = new int []{1,2,3,4,5};
		int actual = Search.binary(array, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBinary_emptyArray() {
		int expected = -1;
		int[] array = new int [4];
		int actual = Search.binary(array, 1);
		assertEquals(expected, actual);
	}

}
