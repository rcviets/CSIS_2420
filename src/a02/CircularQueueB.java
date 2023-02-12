/**
 * 
 */
package a02;

import java.util.Iterator;

/**
 * Implement a generic circular queue using a linked list
 * @author Randa Viets
 *
 */
public class CircularQueueB<Item> implements Iterable<Item> {
	private Node head;
	private Node tail;
	private int capacity; //fixed number of elements that can be stored in queue
	private int n; //items on queue
	
	private class Node {
		Item item;
		Node next;
		
		public Node(Item item) {
			this.item = item;
		}
	}
	
	/**
	 * Constructor empty queue
	 * @param capacity
	 */
	public CircularQueueB(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("Capacity must be greater than 1");
		}
		this.capacity = capacity;
		n = 0;
		head = tail = null;
	}
	
	/**
	 * Check if queue is full by comparing fixed size
	 * with number of items on queue
	 * @return true if full, false if not full
	 */
	public boolean isFull() {
		return n == capacity;
	}
	
	/**
	 * Check if number of items on queue is zero
	 * @return true if empty, false if not empty
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * Return the number of items on queue
	 * @return n items
	 */
	public int size() {
		return n;
	}
	
	/**
	 * Add an item to linked list
	 * @param item to add
	 * @throws UnsupportedOperationException if queue is full
	 */
	public void enqueue(Item item) {
		if (isFull()) {
			throw new UnsupportedOperationException("Queue is full");
		}
		Node node = new Node(item);
		
		if (head == null) {
			head = node;
		} else {
			tail.next = node;
		}
		tail = node;
		tail.next = head;
		n++;
	}
	
	/**
	 * Remove item from linked list
	 * @return null per requirements
	 */
	public Item dequeue() {
		if (isEmpty()) {
			return null;
		}
		
		Item item = head.item;
		head = head.next;
		n--;
		if (isEmpty()) {
			tail = null;
		}
		
		return item;
	}
	
	/**
	 * Return next item in linked list without removing it
	 * @return
	 */
	public Item peek() {
		if (head == null) {
			return null;
		}
		return head.item;
	}
	
	/**
	 * Return an independent iterator over items
	 */
	public Iterator<Item> iterator() {
		return new CircularQueueBIterator();
	}
	
	private class CircularQueueBIterator implements Iterator<Item> {
		private Node current = head;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Item next() {
			if (isEmpty()) {
				throw new java.util.NoSuchElementException();
			}
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	/**
	 * Returns a string that lists all elements
	 * in the order in which they are removed
	 */
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Iterator<Item> iterate = iterator();
		
		while(iterate.hasNext()) {
			sb.append(iterate.next());
			sb.append(" ");
		}
		return sb.toString();
	}
}
