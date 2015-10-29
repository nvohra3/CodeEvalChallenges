package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * You are given two strings. Determine if the second string is a rotation of the first string.
 * https://www.codeeval.com/open_challenges/76/
 */
public class StringRotation {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			String[] inputs = line.split(",");
			if (isRotated(inputs[0].trim(), inputs[1].trim()))
				System.out.println("True");
			else
				System.out.println("False");
		}
		file.close();
	}

	/**
	 * @param word1 first word
	 * @param word2 second word
	 * @return if words are rotated versions of each other
	 */
	private static boolean isRotated(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;
		for (int i = 0; i < word2.length(); i++)
			if (word1.charAt(0) == word2.charAt(i))
			{
				// Start 1 index after the current character since we just matched the current index
				int word1Position = 1;
				int word2Position = (i + 1) % word2.length();
				while (word1Position < word1.length())
				{
					if (word1Position == word1.length() - 1)
						return true;
					if (word1.charAt(word1Position) == word2.charAt(word2Position))
					{
						word1Position++;
						// Update position in word 2 by wrapping around to the beginning if needed
						word2Position = (word2Position + 1) % (word2.length());
					} else
						break;
				}
			}
		return false;
	}
}