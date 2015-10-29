package EasyLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.codeeval.com/open_challenges/31/
 */
public class RightmostChar {
    public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		while (file.hasNextLine())
		{
			String line = file.nextLine();
			// Ignore blank lines
			if (line.equals(""))
				continue;
			// Index 0 contains sentence, and index 1 contains letter to search for
	    	String[] array = line.split(",");
	    	String sentence = array[0];
	    	char letter = array[1].charAt(0);
			System.out.println(findRightmostOccurrence(sentence, letter));
		}
		file.close();
	}

    /**
     * @param line string to search through
     * @param letter character to search for in line
     * @return index of rightmost occurrence of letter in line
     */
    private static int findRightmostOccurrence(String line, char letter) {
    	int occurrence = -1;
    	for (int i = line.length() - 1; i >= 0; i--)
    		if (line.charAt(i) == letter)
    		{
    			occurrence = i;
    			break;
    		}
    	return occurrence;
    }
}
