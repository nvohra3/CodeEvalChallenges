package EasyLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.codeeval.com/open_challenges/8/
 */
public class ReverseWords {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			// Ignore blank lines
			if (!line.equals(""))
				System.out.println(reverseWords(line));
		}
		file.close();
	}

	/**
	 * @param line string to reverse word order of
	 * @return line with reversed order of words
	 */
	private static String reverseWords(String line) {
		sb.setLength(0);
		String[] array = line.split(" ");
		for (int i = array.length - 1; i >= 0; i--)
			sb.append(array[i] + " ");
		return sb.toString();
	}
}
