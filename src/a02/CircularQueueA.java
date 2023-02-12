/**
 * 
 */
package a02;

import java.util.Iterator;

/**
 * Implement a generic circular queue
 * @author Randa Viets
 *
 */
public class CircularQueueA<Item> //implements Iterable<Item>{
	{private Item[] data;
	private int front, rear;
	private int capacity; //fixed number of elements that can be stored in queue
	private int n; //items on queue
	
	/**
	 * Construct empty queue
	 * @param capacity - fixed number of elements that can be stored in queue
	 * @throws IllegalArgumentException if capacity is less than one
	 */
	@SuppressWarnings("unchecked")
	public CircularQueueA(int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("Capacity must be greater than 1");
		}
		this.capacity = capacity;
		n = 0;
		data = (Item[]) new Object[capacity];
		front = -1;
		rear = -1;
	}
	
	/**
	 * Check if queue is full
	 * @return true if full, false if not full
	 */
	public boolean isFull() {
		if (front == 0 && rear == capacity - 1) {
		      return true;
		    }
		    if (front == rear + 1) {
		      return true;
		    }
		    return false;
	}
	/**
	 * Check if queue is empty
	 * @return true is queue is empty, false if not empty
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * Returns the number of items currently in queue
	 * @return n items on queue
	 */
	public int size() {
		return n;
	}
	
	/**
	 * Adds an item to the queue
	 * @param item to add
	 * @throws UnsupportedOperationException if the queue is full
	 */
	public void enqueue(Item item) {
		if (isFull()) {
			throw new UnsupportedOperationException("Queue is full");
		} else {
			if (front == -1) {
				front = 0;
			}
			rear = (rear + 1) % capacity;
			data[rear] = item;
			n++;
		}
		
		//data[rear] = item;
		//rear = (rear + 1) % n;
		//n++;
	}
	
	/**
	 * Delete and return item
	 * @return item that was deleted
	 */
	public Item dequeue() {
		Item item = (Item) data[front];
		front = (front + 1) % capacity;
		n--;
		return item;
	}
	
	/**
	 * Return next item in queue without removing it
	 * @return item
	 */
	public Item peek() {
		return (Item) data[front];
	}
	
	/**
	 * Return an independent iterator over items
	 */
	public Iterator<Item> iterator() {
		return new CircularQueueAIterator();
	}
	
	private class CircularQueueAIterator implements Iterator<Item> {
		private int current = front;
		private int count = 0;
		
		public boolean hasNext() {
			return count < n;
		}
		
		public Item next() {
			if (isEmpty()) {
				throw new java.util.NoSuchElementException();
			}
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			Item item = (Item) data[current];
			current = (current + 1) % capacity;
			count++;
			return item;
		}
	}	 

	/**
	 * Returns a string that lists all elements
	 * in the order in which they are removed'
	 * Returns an empty string if queue is empty
	 */
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Item item : data) {
			sb.append(item.toString());
			sb.append(" ");
		}
		return sb.toString().trim();
	}	 
}
