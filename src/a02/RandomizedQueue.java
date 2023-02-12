/**
 * 
 */
package a02;

import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Randa Viets
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item>{
	private int n;
	private Object[] data;
	
	/**
	 * Construct an empty randomized queue
	 */
	public RandomizedQueue() {
		n = 0;
		data = new Object[1];
	}
	
	/**
	 * Is the queue empty?
	 * @return true if n = 0 otherwise false
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * Returns the number of items in the queue
	 * @return n 
	 */
	public int size() {
		return n;
	}
	
	private void resize(int newSize) {
		if (newSize < 1) {
			return;
		}
		Object [] newData = new Object[newSize];
		for (int i = 0; i < n; i++) {
			newData[i] = data[i];
			data[i] = null;
		}
		data = newData;
	}
	
	/**
	 * Add the item
	 * @param item to be added
	 */
	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		if (n == data.length) {
			resize(data.length * 2);
		}
		data[n] = item;
		n++;
	}
	
	/**
	 * Delete and return a random item
	 * @return random item that was deleted
	 */
	@SuppressWarnings("unchecked")
	public Item dequeue() {
		if (n == 0) {
			throw new java.util.NoSuchElementException();
		}
		int i = StdRandom.uniform(n);
		Item r = (Item) data[i];
		data[i] = data[n-1];
		data[n-1] = null;
		n--;
		if (n <= data.length / 4) {
			resize(data.length /  2);
		}
		return r;
	}
	
	/**
	 * Return but do not delete a random item
	 * @return random item
	 */
	@SuppressWarnings("unchecked")
	public Item sample() {
		if (n == 0) {
			throw new java.util.NoSuchElementException();
		}
		return (Item) data[StdRandom.uniform(n)];
	}
	
	/**
	 * Return an independent iterator over items in random order
	 */
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}
	
	private class RandomizedQueueIterator implements Iterator<Item> {
		private int current = 0;
		private int[] order;
		
		public RandomizedQueueIterator() {
			if (n > 0) {
				order = new int[n];
				for (int i = 0; i < n; i++) {
					order[i] = i;
				}
				StdRandom.shuffle(order, 0, n - 1);
			}
		}
		
		public boolean hasNext() {
			return current < n;
		}
		
		@SuppressWarnings("unchecked")
		public Item next() {
			if (current >= n) {
				throw new java.util.NoSuchElementException();
			}
			Item item = (Item) data[order[current]];
			current++;
			return item;
		}
	}
	
	/**
	 * Unit Testing
	 * @param args
	 */
	public static void main(String[] args) {
		RandomizedQueue<Integer> randqueue = new RandomizedQueue<Integer>();
		int N = Integer.parseInt(args[0]);
		double prob = Double.parseDouble(args[1]);
		for (int i = 0; i < N; i++) {
			if (StdRandom.uniform() < prob) {
				try {
					randqueue.enqueue(1);
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					System.out.println(Arrays.toString(randqueue.data));
					throw new java.lang.ArrayIndexOutOfBoundsException();
				}
			} else {
				try {
					randqueue.dequeue();
				} catch (java.util.NoSuchElementException e) {
					// Ignore
				}
			}
		}
	}
}
