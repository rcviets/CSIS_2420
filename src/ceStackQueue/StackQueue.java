package ceStackQueue;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * CE Stack Queue Part 2
 * Exercise to practice the use of stacks and queues.
 * 
 * @author CSIS 2420 Starter Code & Randa Viets
 *
 */
public class StackQueue {

	/**
	 * Performs the following transformations:
	 * Replaces the characters '1' with 'i'
	 * Removes characters that are not letters
	 * Removes upper-case letters
	 * 
	 * Example: [9 h ; e l # A l D 0 o . ] => [h e l l o ]
	 * 
	 * @param q
	 * @return transformed input
	 */
	private static Iterable<Character> transformationA(Queue<Character> q) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			char n = q.dequeue();
			if (n == '1') {
				q.enqueue('i');
			} else if (Character.isLetter(n) && Character.isLowerCase(n)) {
				q.enqueue(n);
			} 	
		}
		return q;
	}
	

	/**
	 * Performs the following transformations:
	 * Duplicate all slashes and backslashes ( / and  \ )
	 * Add the reversed (transformed) character sequence to the end. 
	 * 
	 * Example: [. / ^ \ ~ ] => [. / / ^ \ \ ~ ~ \ \ ^ / / . ]
	 * 
	 * @param q
	 * @return transformed input
	 */
	private static Iterable<Character> transformationB(Queue<Character> q) {
		Stack<Character> s = new Stack<>();
		int size = q.size();
		for (int i = 0; i < size; i++) {
			char n = q.dequeue();
			q.enqueue(n);
			s.push(n);
			if (n == '/' || n == '\\') {
				q.enqueue(n);
				s.push(n);
			}
		}
		int size2 = s.size();
		for (int i = 0; i < size2; i++) {
			q.enqueue(s.pop());
		}
		
		return q;
	}
	
	public static void main(String[] args) {
		Queue<Character> inputQueue = new Queue<>();
		for(Character c : new Character[] {'9', 'h', ';', 'e', 'l', '#', 'A', 'l', 'D', '0', 'o', '.'}) {
			inputQueue.enqueue(c);
		}
		testTransformA(inputQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'f', 'R', 'e', '!', 'P', 'l', '1', 'c', '1', 'D', '5', 't', ';', 'y'}) {
			inputQueue.enqueue(c);
		}
		testTransformA(inputQueue);
		
		Queue<Character> emptyQueue = new Queue<>();
		for(Character c : new Character[0]) {
			emptyQueue.enqueue(c);
		}
		testTransformA(emptyQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'.', '/', '^', '\\', '~'}) {
			inputQueue.enqueue(c);
		}
		testTransformB(inputQueue);
		
		inputQueue = new Queue<>();
		for(Character c : new Character[] {'/', 'A', '|', 'A', '\\', 'o'}) {
			inputQueue.enqueue(c);
		}
		testTransformB(inputQueue);
		
		testTransformB(emptyQueue);
	}

	private static void testTransformA(Queue<Character> queue) {
		StdOut.println("TransformA (input: [" + queue + "])");
		StdOut.print("output: [");
		for (Character c : transformationA(queue)) {
			StdOut.print(c + " "); 
		}
		StdOut.println("]\n");
	}
	
	private static void testTransformB(Queue<Character> queue) {
		StdOut.println("TransformB (input: [" + queue + "])");
		StdOut.print("output: [");
		for (Character c : transformationB(queue)) {
			StdOut.print(c + " "); 
		}
		StdOut.println("]\n");
	}
}
