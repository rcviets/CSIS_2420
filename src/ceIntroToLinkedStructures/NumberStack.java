package ceIntroToLinkedStructures;

import java.util.NoSuchElementException;

/**
 * Represents a last in first out stack of whole numbers.
 * Typical stack operations and linked nodes
 * 
 * @author Randa Viets
 *
 */
public class NumberStack {
	private Node top;
	private int n = 0;
	
	/**
	 * Node that consisting of data and link to next node
	 * @author Randa Viets
	 *
	 */
	private class Node {
		private int data;
		private Node next;
	}
	
	/**
	 * Determines whether the stack is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * Add number to the stack
	 * @param number
	 */
	public void push (int number) {
		Node node = new Node();
		node.data = number;
		node.next = top;
		top = node;
		n++;
	}
	
	/**
	 * Removes most recently added element from stack
	 * @return number removed
	 * @throws NoSuchElementException if stack is empty
	 */
	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		int element = top.data;
		top = top.next;
		n--;
		return element;
	}
	
	/**
	 * Return most recently added element without
	 * changing the stack
	 * @return number added to the list
	 * @throws NoSuchElementException if stack is empty
	 */
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		return top.data;
	}
	
	/**
	 * Determines the number of elements on the stack
	 * @return stack size
	 */
	public int size() {
		return n;
	}
	
	// = = = test client = = = 

	public static void main(String[] args) {
	   NumberStack stack = new NumberStack();
	   stack.push(1);
	   stack.push(2);
	   stack.push(3);
	   System.out.println("last element removed: " + stack.pop());
	   System.out.println("view new last element: " + stack.peek());
	   int size = stack.size();
	   System.out.println("size: " + size);
	   boolean empty = stack.isEmpty();
	   System.out.println("isEmpty: " + empty);
	}
}
