package ceLinked;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * WordList is a singly-linked list of Strings.
 * It is designed as a practice opportunity to
 * learn how to manipulate linked stuctures.
 * 
 * @author Randa Viets
 */
public class WordList implements Iterable<String> {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n;     // number of words in the list

	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private String item;
		private Node next;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * end of the list.
	 * 
	 * @param newItem
	 */
	public void append(String newItem) {
		// create a new node based on the word provided by the user
		Node newNode = new Node();
		newNode.item = newItem;
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		n++;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * front of the list.
	 * 
	 * @param newItem
	 */
	public void prepend(String newItem) {		
		Node newNode = new Node();
		newNode.item = newItem;
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			Node temp = head;
			head = newNode;
			head.next = temp;
		}
		n++;
	}
	
	/** 
	 * Returns the index of the first occurrence of the specified item.
	 * If the specified item in not part of the list
	 * the method indexOf returns -1
	 * 
	 * @param item
	 * @return index of the first occurrence of the item; -1 if the word was not found.
	 */
	public int indexOf(String item) {		
		Node current = head;
		
		for (int i = 0; i < n; i++) {
			if (current == null) {
				break;
			} else if (current.item == item) {
				return i;
			} else {
				current = current.next;
			}
		}
		return -1;
	}
	
	/** 
	 * Checks whether the list contains the given item.
	 * 
	 * @param item
	 * @return true if the item is contained in the list; false otherwise.
	 */
	public boolean contains(String item) {	
		Node current = head;
		
		for (int i = 0; i < n; i++) {
			if (current == null) {
				break;
			} else if (current.item == item) {
				return true;
			} else {
				current = current.next;
			}
		}
		return false;
	}
	
	/**
	 * Returns the number of elements in the list
	 * @return the number of elements
	 */
	public int size() {
		return n;
	}
	
	/** 
	 * Determines whether the list is empty or not.
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		
		while(current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		
		return sb.toString();
	}
	
	public Iterator<String> iterator() {
		return new WordListIterator();
	}
	
	
	private class WordListIterator implements Iterator<String> {
		Node current = head;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public String next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			String data = current.item.toString();
			current = current.next;
			return data;
		}
	}
	
	/* * * * * * * * Test Client * * * * * * */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WordList list = new WordList();
		System.out.println("size: " + list.size());
		
		// Dynamically determine whether the list is empty. If so, print 
		// 'The list is empty.' otherwise print 'The list is not empty.'
		String sizeCheck = list.isEmpty() ? "The list is empty." : "The list is not empty.";
		System.out.println(sizeCheck);
		System.out.println();
		
		list.prepend("ape");
		list.append("ant");
		list.append("bat");
		list.append("cow");
		list.append("dog");
		
		System.out.println("TODO 2: prepend 'ape'");
		System.out.println("list: " + list);
		System.out.println("size: " + list.size());
		System.out.println();
		
		list.prepend("auk");
		
		System.out.println("TODO 2: prepend 'auk'");
		System.out.println("list: " + list);
		System.out.println("size: " + list.size());
		System.out.println();
		
		System.out.println("TODO 3: indexOf");
		System.out.println("Index of dog: " + list.indexOf("dog"));
		System.out.println("Index of auk: " + list.indexOf("auk"));
		System.out.println("Index of yak: " + list.indexOf("yak"));
		System.out.println();
		
		System.out.println("TODO 4: contains");
		String containCheck = "";
		System.out.print("cow");
		System.out.println(containCheck = list.contains("cow") ? " is included in the list." : " is not included in the list.");
		System.out.print("yak");
		System.out.println(containCheck = list.contains("yak") ? " is included in the list." : " is not included in the list.");
		System.out.println();
		
		System.out.println("list: " + list);
		System.out.println("size: " + list.size());
		System.out.println();
		
		System.out.println("List elements printed with a foreach loop");
		for (String element : list) {
			System.out.print(element + " ");
		}
	}
}
