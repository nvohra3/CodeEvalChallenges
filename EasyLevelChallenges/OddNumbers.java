package EasyLevelChallenges;

/**
 * https://www.codeeval.com/open_challenges/25/
 */
public class OddNumbers {
	public static void main(String[] args) {
		printOddNumbers(99);
	}

	/**
	 * Prints odd numbers starting from 1 through given max
	 * @param max number to stop printing odd values at
	 */
	private static void printOddNumbers(int max) {
		for (int i = 1; i < max; i += 2)
			System.out.println(i);
	}
}