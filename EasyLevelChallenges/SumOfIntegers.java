package EasyLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.codeeval.com/open_challenges/24/
 */
public class SumOfIntegers {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		int total = 0;
		while (file.hasNextLine())
		{
			String stringNum = file.nextLine();
			int num = Integer.parseInt(stringNum);
			total += num;
		}
		file.close();
		System.out.println(total);
	}
}
