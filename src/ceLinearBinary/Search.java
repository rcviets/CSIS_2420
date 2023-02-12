/**
 * 
 */
package ceLinearBinary;

/**
 * Contains methods Linear and Binary
 * @author Randa Viets
 *
 */
public class Search {
	
	/**
	 * Search array for specified key based
	 * on a linear search algorithm
	 * @param numbers
	 * @param key number to search
	 * @return index of first occurrence of key
	 * or -1 if the key was not found
	 */
	public static int linear(int[] numbers, int key) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Search array for specified key based
	 * on a binary search algorithm
	 * @param numbers
	 * @param key number to search
	 * @return index of first occurrence of key
	 * or -1 if the key was not found
	 */
	public static int binary(int[] numbers, int key) {
		int first = 0;
		int last = numbers.length - 1;
		int middle = (first + last) / 2;
		
		while (first <= last) {
			if (numbers[middle] < key) {
				first = middle + 1;
			} else if (numbers[middle] == key) {
				return middle;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		return - 1;
	}
}
