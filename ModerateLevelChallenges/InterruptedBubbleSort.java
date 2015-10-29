package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.codeeval.com/open_challenges/158/
 */
public class InterruptedBubbleSort {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		StringBuilder sb = new StringBuilder();
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			String[] input = line.split("\\|");
			String[] stringList = input[0].trim().split(" ");
			int[] list = new int[stringList.length];
			for (int i = 0; i < stringList.length; i++)
				list[i] = Integer.parseInt(stringList[i]);
			// One of the inputs on CodeEval had a iteration number greater than the int max size,
			// so I just used a double here as a quick fix
			double numIterations = Double.parseDouble(input[1].trim());
			list = bubbleSort(list, numIterations);
			for (int i = 0; i < list.length; i++)
				sb.append(list[i] + " ");
			System.out.println(sb.toString());
			sb.setLength(0);
		}
		file.close();
	}

	/**
	 * Performs specified number of iterations of bubble sort on list
	 * @param list array of integers
	 * @param numIterations number of bubble sort iterations
	 * @return partially sorted list
	 */
	private static int[] bubbleSort(int[] list, double numIterations) {
		boolean swapMade = false;
		for (int i = 0; i < numIterations; i++)
		{
			for (int j = 0; j < list.length - i - 1; j++)
				if (list[j] > list[j + 1])
				{
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					swapMade = true;
				}

			// If list is already sorted, then stop performing bubble sort and return
			if (!swapMade)
				return list;
			swapMade = false;
		}
		return list;
	}
}