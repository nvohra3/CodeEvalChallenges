package ModerateLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * Write a program which finds the first non-repeated character in a string.
 * https://www.codeeval.com/open_challenges/12/
 */
public class FirstNonrepeatedCharacter {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			System.out.println(findFirstNonrepeatedCharacter(line));
		}
		file.close();
	}

	/**
	 * Finds the first non-repeated character in string (assuming English alphabet
	 * input). Works by seeing which characters are repeated and keeping track of
	 * each character's first occurrence in the string.
	 * @param input string to search through
	 * @return first non-repeated character
	 */
	private static char findFirstNonrepeatedCharacter(String input) {
		HashMap<Character, CharacterInfo> numOccurrences = new HashMap<Character, CharacterInfo>();
		input = input.toLowerCase();

		for (int i = 0; i < input.length(); i++)
		{
			char letter = input.charAt(i);
			if (numOccurrences.containsKey(letter))
			{
				CharacterInfo info =  numOccurrences.get(letter);
				info.numOccurrences++;
				numOccurrences.put(letter, info);
			} else
				numOccurrences.put(letter, new CharacterInfo(i));
		}

		Set<Entry<Character, CharacterInfo>> set = numOccurrences.entrySet();
		Iterator<Entry<Character, CharacterInfo>> iterator = set.iterator();
		Entry<Character, CharacterInfo> firstNonRepeatedCharEntry = null;
		while (iterator.hasNext())
		{
			Entry<Character, CharacterInfo> current = iterator.next();
			if (current.getValue().numOccurrences > 1)
				continue;
			if (firstNonRepeatedCharEntry == null)
			{
				firstNonRepeatedCharEntry = current;
				continue;
			}

			if (current.getValue().firstOccurrenceIndex < firstNonRepeatedCharEntry.getValue().firstOccurrenceIndex)
				firstNonRepeatedCharEntry = current;
		}

		if (firstNonRepeatedCharEntry == null) // In the event of no repeating character, return null
			return '\u0000';
		else
			return firstNonRepeatedCharEntry.getKey();
	}

	/**
	 * Class to keep information on each character in input
	 */
	private static class CharacterInfo {
		private int numOccurrences;
		private int firstOccurrenceIndex;

		public CharacterInfo(int firstOccurrenceIndex) {
			this.firstOccurrenceIndex = firstOccurrenceIndex;
			numOccurrences = 1;
		}
	}
}