package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Imagine we have an immutable array of size N which we know to be filled with integers
 * ranging from 0 to N-2, inclusive. Suppose we know that the array contains exactly one
 * duplicated entry and that duplicate appears exactly twice. Find the duplicated entry.
 * (For bonus points, ensure your solution has constant space and time proportional to N)
 * https://www.codeeval.com/open_challenges/41/
 */
public class ArrayAbsurdity {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			int semicolonPosition = line.indexOf(';');
			line = line.substring(semicolonPosition + 1);
			String[] stringArray = line.split(",");
			int[] nums = new int[stringArray.length];
			for (int i = 0; i < stringArray.length; i++)
				nums[i] = Integer.parseInt(stringArray[i]);
			System.out.println(findDuplicate(nums));
		}
		file.close();
	}

	/**
	 * Finds duplicate entry in array containing numbers from 0 to size - 2
	 * @param array array containing duplicated entry
	 * @return duplicated entry
	 */
	private static int findDuplicate(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++)
			sum += array[i];
		// Sum of integers from 0 to n - 2 is equal to ((n - 2) * (n - 1)) / 2
		int expectedTotal = ((array.length - 2) * (array.length - 1)) / 2;
		return (sum - expectedTotal);
	}
}
