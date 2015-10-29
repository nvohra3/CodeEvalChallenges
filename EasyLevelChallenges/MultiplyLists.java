package EasyLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.codeeval.com/open_challenges/113/
 */
public class MultiplyLists {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File(args[0]));
        while (file.hasNextLine())
        {
        	String line = file.nextLine();
        	int listSplit = line.indexOf("|");
        	String[] stringList1 = line.substring(0, listSplit - 1).split(" ");
        	// Move past pipe character and to first element of second list with listSplit + 2
        	String[] stringList2 = line.substring(listSplit + 2).split(" ");
        	System.out.println(multiplyLists(stringList1, stringList2));
        }
        file.close();
	}

	/**
	 * Multiplies corresponding values of two lists together
	 * Format of input is specified in link above
	 * @param line string containing two lists
	 * @return string containing multiplied numbers
	 */
	private static String multiplyLists(String[] stringList1, String[] stringList2) {
    	sb.setLength(0);
        for (int i = 0; i < stringList1.length; i++)
    	{
    		int mult = Integer.parseInt(stringList1[i]) * Integer.parseInt(stringList2[i]);
    		sb.append(String.valueOf(mult) + " ");
    	}
    	return sb.toString();
	}
}
