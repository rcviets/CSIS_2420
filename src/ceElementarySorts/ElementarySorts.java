/**
 * 
 */
package ceElementarySorts;

/**
 * @author Randa Viets
 *
 */
public class ElementarySorts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {75, 60, 13, 8, 23, 12, 0};
		
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		System.out.println(arr);
		System.out.println("Selection Sort Time: " + (endTime - startTime) + " milliseconds");
		
		startTime = System.currentTimeMillis();
		insertSort(arr);
		endTime = System.currentTimeMillis();
		System.out.println("Selection Insert Time: " + (endTime - startTime) + " milliseconds");
	}
	
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i +1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void insertSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int key = arr[i];
			int j = i -1;
			
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

}
