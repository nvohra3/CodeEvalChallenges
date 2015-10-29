package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The sentence 'A quick brown fox jumps over the lazy dog' contains every
 * single letter in the alphabet. Such sentences are called pangrams. You
 * are to write a program, which takes a sentence, and returns all the
 * letters it is missing (which prevent it from being a pangram). You should
 * ignore the case of the letters in sentence, and your return should be all
 * lower case letters, in alphabetical order. You should also ignore all non
 * US-ASCII characters.In case the input sentence is already a pangram,
 * print out the string NULL
 * https://www.codeeval.com/open_challenges/37/
 */
public class Pangrams {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			System.out.println(findMissingLetters(line));
		}
		file.close();
	}

	/**
	 * @param line string to search through for missing letters
	 * @return letters of English alphabet not in string
	 */
	private static String findMissingLetters(String line) {
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		boolean[] isLetterMissing = new boolean[26];
		line = line.toLowerCase();
		for (int i = 0; i < line.length(); i++)
		{
			char letter = line.charAt(i);
			char arrayEntry = (char) (letter - 'a');
			if (0 <= arrayEntry && arrayEntry <= 25)
				isLetterMissing[arrayEntry] = true;
		}

		for (int i = 0; i < isLetterMissing.length; i++)
			if (!isLetterMissing[i])
				sb.append((char) (i + 'a'));
		String missingLetters = sb.toString();
		if (missingLetters.equals(""))
			return "NULL";
		else
			return sb.toString();
	}
}