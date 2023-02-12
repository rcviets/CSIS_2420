package a01;

/**
 * Coding challenges for assignment A01 part2.
 * 
 * @author CSIS Starter Code + ....... (add your name here)
 *
 */
public class A01Part2 {
	
	/**
	 * Finds the shortest sequence of consecutive array elements that add up to 
	 * the specified sum and returns the length of that sequence. 
	 * If no such sequence is found, the method returns 0.    
	 * <p>
	 * E.g., [2, 10, 4, 8, 1, 22, 5, 16, 2] and sum = 23 returns 2
	 * This example has three sequences that add up to 23: 10 + 4 + 8 + 1, 1 + 22, and 5 + 16 + 2.
	 * Since 1 + 22 is the shortest, the method returns 2.
	 * E.g., [1, -7, 4, 0]  and sum = -2 returns 3 because 1 - 7 + 4 equals -2
	 * <p> 
	 * Boundary cases:
	 * If the array is empty or if the user passes null as the first argument, the 
	 * method should return 0. No exception should be thrown.      
	 * 
	 * @param array
	 * @param sum 
	 * @return the minimum number of consecutive addends to calculate the specified sum. 
	 */
	public static int minNumberOfAddends(int[] array, int sum) {
		if (array == null || array.length == 0) {
			return 0;
		}
		
	    int n = array.length;
	    int start = 0, end = 0, curr_sum = array[0], min_len = Integer.MAX_VALUE;
	    while (end < n) {
	        while (curr_sum > sum && start < end) {
	            curr_sum -= array[start];
	            start++;
	        }
	        if (curr_sum == sum) {
	            min_len = Math.min(min_len, end - start + 1);
	        }
	        if (end < n - 1) {
	            curr_sum += array[++end];
	        } else {
	            break;
	        }
	    }
	    return min_len == Integer.MAX_VALUE ? 0 : min_len;
	}
	
	/**
	 * Changes the two-dimensional array by multiplying each value with 2.
	 * E.g., [3, 4, 1]                [6, 8, 2]
	 *       [4, 0, 2, 2] changes to  [8, 0, 4, 4]
	 *       [1, 4]                   [2, 8]
	 * <p>
	 * Boundary cases:
	 * If the two-dimensional array is empty or if the user passes null as an argument, 
	 * an IllegalArgumentException should be thrown. 
	 * 
	 * @param array2d
	 * @throws IllegalArgumentException if the array is empty or the argument is null.
	 */
	public static void doubleValues(int[][] array2d) {
		if (array2d == null || array2d.length == 0) {
			throw new IllegalArgumentException();
		}
		
	    for (int i = 0; i < array2d.length; i++) {
	        for (int j = 0; j < array2d[i].length; j++) {
	            array2d[i][j] *= 2;
	        }
	    }
	}
	
	/**
	 * Determines whether the matrix includes a golden ticket. 
	 * A golden ticket consists of 6 upper-case 'G' where three pairs of Gs are right above each other
	 * as shown below. Note that I left out the single quotes to improve readability.
	 * 
	 * G G
	 * G G
	 * G G
	 * <p>
	 * E.g., [A b - - C d m]  
	 *       [- G G Z G G -] 
	 *       [H o - r G G D]   this matrix returns true
	 *       [H o - r G G D]
	 *       
	 * E.g., [R g G - C d m W]  
	 *       [- G G Z G G - r]   this matrix returns false
	 *       [o G G G r G G D]   because the Gs are not in the specified position
	 *       [S t C - G G a -]   relative to each other
	 * <p>
	 * The matrix should be 'rectangular', which means, all rows should have 
	 * the same number of elements. If that is not the case, an IllegalArgumentException 
	 * should be thrown.
	 * <p>
	 * Boundary cases:
	 * If the two-dimensional array is empty or the user passes null as an argument, the
	 * method should return false. 
	 * 
	 * @param matrix
	 * @throws IllegalArgumentException if the rows vary in length.
	 */
	public static boolean goldenTicket(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		
	    int rows = matrix.length;
	    int cols = matrix[0].length;

	    //check if matrix is rectangular
	    for (int i = 1; i < rows; i++) {
	        if (matrix[i].length != cols) {
	            throw new IllegalArgumentException("Matrix is not rectangular");
	        }
	    }

	    for (int i = 0; i < rows - 2; i++) {
	        for (int j = 0; j < cols; j++) {
	            if (matrix[i][j] == 'G' && matrix[i+1][j] == 'G' && matrix[i+2][j] == 'G'
	                && matrix[i][j] == 'G' && matrix[i+1][j] == 'G' && matrix[i+2][j] == 'G') {
	                return true;
	            }
	        }
	    }
	    return false;
	}

} 
