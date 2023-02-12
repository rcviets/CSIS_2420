package a02;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularQueueATest {
	CircularQueueA<Integer> queue;

	@BeforeEach
	void setUp() throws Exception {
		queue = new CircularQueueA<>(5);
	}

	@Test
	void testIsFull() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertTrue(queue.isFull());
	}

	@Test
	void testIsNotFull() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		assertFalse(queue.isFull());
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	void testIsNotEmpty() {
		queue.enqueue(1);
		assertFalse(queue.isEmpty());
	}

	@Test
	void testSize() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(4, queue.size());
	}

	@Test
	void testEnqueue() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals("1 2 3 4 5", queue.toString());
	}

	@Test
	void testEnqueueException() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertThrows(UnsupportedOperationException.class, () -> queue.enqueue(6));
	}

	@Test
	void testDequeue() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(1, (int)queue.dequeue());
		assertEquals(2, (int)queue.dequeue());
		assertEquals(3, (int)queue.dequeue());
		assertEquals(4, (int)queue.dequeue());
		assertEquals(5, (int)queue.dequeue());
	}
	
	@Test
	void testIterator() {
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	    queue.enqueue(4);
	    queue.enqueue(5);

	    Iterator<Integer> iterator = queue.iterator();
	    StringBuilder sb = new StringBuilder();
	    while (iterator.hasNext()) {
	        sb.append(iterator.next() + " ");
	    }

	    assertEquals("1 2 3 4 5 ", sb.toString());
	}
	
	void testToString() {
	    queue.enqueue(1);
	    queue.enqueue(2);
	    queue.enqueue(3);
	    queue.enqueue(4);
	    queue.enqueue(5);
	    
	    String expected = "1 2 3 4 5";
	    String actual = queue.toString();
	    
	    assertEquals(expected, actual);
	}

}
