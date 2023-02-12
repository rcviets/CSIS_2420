/**
 * 
 */

/**
 * @author Randa Viets
 * Calculate Hailstone numbers using recursion
 */
public class ceRecursion {
	
	public static void Hailstone(int seed) {
		if (seed < 0) {
			throw new IllegalArgumentException("The provided seed needs to be a positive number");
		}
		System.out.print(seed + " ");
		if (seed == 1) {
			return;
		} else if (seed % 2 == 0) {
				Hailstone(seed / 2);
			} else {
				Hailstone(seed * 3 + 1);
			}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hailstone Numbers");
		System.out.println("-------------------");
		
		Hailstone(3);
		System.out.println();
		
		Hailstone(16);
		System.out.println();
		
		Hailstone(17);
		System.out.println();
		
		Hailstone(24);
	}

}
