package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Write a program to determine the largest sum of contiguous integers in a list.
 * https://www.codeeval.com/open_challenges/17/
 */
public class SumOfIntegers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			String[] stringArray = line.split(",");
			int[] array = new int[stringArray.length];
			for (int i = 0; i < stringArray.length; i++)
				array[i] = Integer.parseInt(stringArray[i]);
			System.out.println(largestContiguousSum(array));
		}
		file.close();
	}

	/**
	 * @param array list of integers
	 * @return largest sum of contiguous integers in the list
	 */
	private static int largestContiguousSum(int[] array) {
		int maxSum = array[0];
		int currentSum = 0;
		for (int i = 0; i < array.length; i++)
		{
			currentSum += array[i];
			if (maxSum < currentSum)
				maxSum = currentSum;

			if (currentSum < 0)
			{
				currentSum = 0;
				continue;
			}
		}
		return maxSum;
	}
}
