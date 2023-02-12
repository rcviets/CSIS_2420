package a02;

import java.util.NoSuchElementException;

/**
 * Linked List that stores the elements in sorted order based on the 
 * implementation  of Comparable<Item>.
 * The elements are internally stored in a doubly-linked list, and 
 * null elements are not allowed.
 * 
 * @author CSIS Starter Code + Randa Viets
 *  
 * @param <Item> type of elements stored in the sorted list
 */
public class SortedList<Item> implements Comparable<Item> {
	Item item;
	private Node head;
	@SuppressWarnings("unused")
	private Node tail;
	private int n;
	
	/**
	 * Represents a node in a double linked list.
	 */ 
	private class Node {
		Item item;
		Node next;
		@SuppressWarnings("unused")
		Node previous;
		
		public Node(Item item) {
			this.item = item;
		}
	}
	
	/**
	 * Determines whether the list is empty.
	 * 
	 * @return true if there are no elements in the list and false otherwise
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * Determines how many elements are in the list.
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return n;
	}

	/**
	 * Adds <code>item</code> to the list while maintaining the list's sorted order.
	 * 
	 * @param item element to add to the sorted list
	 * @throws NullPointerException if the specified element is null
	 */
	@SuppressWarnings("unchecked")
	public void insert(Item item) {
		if (item == null) {
			throw new NullPointerException("Item can't be null");
		}
		Node node = new Node(item);
		
		if (head == null) {
			head = node;
			tail = node;
		} else if (head.next == null){
			if (((Comparable<Item>) head.item).compareTo(item) < 0) {
				head.next = node;
				tail = node;
			} else {
				node.next = head;
				head = node;
			}
		} else {
			Node current = head;
			Node previous = null;
			while (!isEmpty() && ((Comparable<Item>) current.item).compareTo(item) <0) {
				previous = current;
				current = current.next;
			}
			node.next = current;
			previous.next = node;
		}
		n++;
	}

	/**
	 * Deletes the element on the specified <code>index</code> 
	 * and returns the value of the deleted element.
	 * 
	 * @param index position of the element that needs to be deleted
	 * @return the deleted item
	 * @throws NoSuchElementException if the method is called on an empty list
	 * @throws IndexOutOfBoundsException if the specified index is not in the range [0, n)
	 */
	public Item delete(int index) {
		if (isEmpty()) {
			throw new NoSuchElementException("The list is empty");
		}
		if (index < 0 || index >= n) {
			throw new IndexOutOfBoundsException("Index is not within the range of available indices");
		}
		Node current = head;
		Node previous = null;
		
		if (index == 0) {
			head = head.next;
			if (head != null) {
				head.previous = null;
			}
		} else {
			for (int i = 0; i < index; i++) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
			if (current.next != null) {
				current.next.previous = previous;
			}
		}
		n--;
		return current.item;
	}
	
	/**
	 * Updates the element on the specified <code>index</code> by replacing it with <code>item</code>
	 * and moves the updated node as needed to restore the sorted order of the list.
	 * <p>
	 * Examples:<br/>
	 * Given the list 10-20-30-40-50 <br/>
	 * a) updating index 2 with 33 results in 10-20-33-40-50 <br/>
	 * b) updating index 3 with 15 results in 10-15-20-30-50 <br/>
	 * c) updating index 1 with 60 results in 10-30-40-50-60 <br/>
	 * 
	 * @param index position of the element that needs to be updated
	 * @param item new value of the updated element
	 * @throws IndexOutOfBoundsException if the specified index is not in the range [0, n)
	 * @throws NoSuchElementException if this list is empty
	 * @throws NullPointerException if this list is not empty and the item passed to the method is null
	 */
	public void update(int index, Item item) {
		if (isEmpty()) {
			throw new NoSuchElementException("The list is empty");
		}
		if (item == null) {
			throw new NullPointerException("Item can't be null");
		}
		if (index < 0 || index >= n) {
			throw new IndexOutOfBoundsException("Index is not within the range of available indices");
		}
		Node current = head;
		
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		@SuppressWarnings("unused")
		Item previous = current.item;
		current.item = item;
	}

	
	/**
	 * Builds a string that includes all the list elements in order. 
	 * Each element is followed by a single space.
	 * If this list is empty, and empty string is returned.
	 * 
	 * @return a string representation of the sorted list
	 */
	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			sb.append(temp.item + " ");
			temp = temp.next;
		}
		return sb.toString().trim();
	}

	// = = = Optional Test Client = = =
	
	public static void main(String[] args) {
		
	}

	@Override
	public int compareTo(Item otherNode) {
		return 0;
	}


}
