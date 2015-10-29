package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * You are given a sorted array of positive integers and a number 'X'. Print
 * out all pairs of numbers whose sum is equal to X. Print out only unique
 * pairs and the pairs should be in ascending order
 * https://www.codeeval.com/open_challenges/34/
 */
public class NumberPairs {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		StringBuilder sb = new StringBuilder();
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			String[] inputs = line.split(";");
			String[] stringArray = inputs[0].split(",");
			int[] array = new int[stringArray.length];
			for (int i = 0; i < stringArray.length; i++)
				array[i] = Integer.parseInt(stringArray[i]);
			int sum = Integer.parseInt(inputs[1]);
			List<NumberPair> pairs = findNumberPairs(array, sum);
			for (int i = 0; i < pairs.size(); i++)
				sb.append(pairs.get(i).num1 +"," + pairs.get(i).num2 + ";");
			String stringPairs = sb.toString();
			if (stringPairs.equals(""))
				System.out.println("NULL");
			else
				// Get rid of that semicolon at the end
				System.out.println(stringPairs.substring(0, stringPairs.length() - 1));
			sb.setLength(0);
		}
		file.close();
	}

	/**
	 * @param array list of integers
	 * @param sum integer which pairs of numbers from array must add up to
	 * @return list of numbers that add up to sum
	 */
	private static List<NumberPair> findNumberPairs(int[] array, int sum) {
		List<NumberPair> pairs = new ArrayList<NumberPair>();
		int i = 0;
		int j = array.length - 1;
		while (i < j)
		{
			if (j > array.length)
				return pairs;
			if (array[i] + array[j] > sum)
				j--;
			else if (array[i] + array[j] < sum)
				i++;
			else
			{
				pairs.add(new NumberPair(array[i], array[j]));
				i++;
				j--;
			}
		}
		return pairs;
	}

	private static class NumberPair {
		private int num1;
		private int num2;

		public NumberPair(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}
	}
}
