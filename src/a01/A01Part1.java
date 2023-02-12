package a01;


/**
 * Coding challenges for assignment A01 part1.
 * 
 * @author CSIS Starter Code + ....... Randa Viets
 *
 */
public class A01Part1 {
	
	/**
	 * Returns a new array that includes every other number starting with the first.
	 * E.g., [10, 20, 30, 40, 50, 60] returns [10, 30, 50]
	 * E.g., [10] returns [10]
	 * <p>
	 * Boundary cases:
	 * If the array is empty, an empty array should be returned. 
	 * If the user passes null as an argument, the method should return null.
	 * 
	 * @param numbers original array of whole numbers
	 * @return array that includes every other number starting with the first
	 */
	public static int[] everyOther(int[] numbers) {
		int arrLength;
		
		if (numbers == null) {
			return null;
		} 
		
		if (numbers.length < 2) {
			return numbers;
		} 
		
		if (numbers.length % 2 != 0) {
			arrLength = (numbers.length/2) + 1;
		} else {
			arrLength = numbers.length/2;
		}

		int[] newNumbers = new int [arrLength];
		int j = 0;
		for (int i = 0; i < numbers.length; i = i + 2) {
			newNumbers[j] = numbers[i];
			j++;
		}
		return newNumbers;
	}
	
	/**
	 * Returns a new array that includes commas as thousands separators.
	 * E.g., ['7', '6', '5', '4', '3', '2', '1'] returns ['7', ',', 6, 5, 4, ',', 3, 2, 1] 
	 * E.g., ['5', '3', '6'] returns ['5', '3', '6']
	 * <p>
	 * Boundary cases:
	 * If the array is empty, an empty array should be returned. 
	 * If the user passes null as an argument, the method should return null.
	 * 
	 * @param digits original array of digits
	 * @return new array that includes commas as thousands separators.
	 * @throws IllegalArgumentException if the array <code>digits</code> includes
	 * any characters that are not digits.
	 */
	public static char[] addSeparators (char[] digits) {
		if (digits == null) {
			return null;
		} 
		
		if (digits.length < 1) {
			return digits;
		}
		
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] < '0' || digits[i] > '9') {
				throw new IllegalArgumentException("The array contains characters that are not digits");
			} 
		}
		
		String str = String.valueOf(digits);
		StringBuilder sb = new StringBuilder();
		
		for (int i = str.length(); i > 0; i -= 3) {
			if (sb.length() > 0) {
				sb.insert(0, ",");
			}
			sb.insert(0, str.substring(Math.max(0,  i -3 ), i));
		}
		return sb.toString().toCharArray();
	}

	/**
	 * Determines whether the order of the elements in the array from front to back
	 * is the same as the order of the elements from back to front.
	 * E.g., ['r', 'a', 'c', 'e', 'c', 'a', 'r'] returns true
	 * E.g., ['D', 'a', 'd'] returns false (case matters)
	 * E.g., [10, 20] returns false
	 * E.g., ["hello"] returns true (a single element is a palindrome)
	 * 
	 * @param array
	 * @return true if the array is a palindrome and false otherwise
	 * @throws IllegalArgumentException if the array includes no elements or
	 * if the argument passed to the method is null.
	 */
	public static <T> boolean isPalindrome(T[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Array does not contain elements or is null");
		}
		
		if (array.length < 2) {
			return true;
		}
		
		int flag = 0;
		for (int i = 0; i <= array.length / 2; i++) {
			if (array[i] != array[array.length - i - 1]) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
} 
