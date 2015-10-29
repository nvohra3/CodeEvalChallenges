package EasyLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.codeeval.com/open_challenges/21/
 */
public class SumOfDigits {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File(args[0]));
		while (file.hasNextLine())
		{
			String stringNum = file.nextLine();
			System.out.println(sumOfDigits(stringNum));
		}
		file.close();
	}

	/**
	 * @param stringNum string representation of int
	 * @return sum of digits of stringNum
	 */
	private static int sumOfDigits(String stringNum) {
		int num = Integer.parseInt(stringNum);
		int total = 0;
		for (int i = stringNum.length(); i >= 0; i--)
		{
			total += num % 10;
			num /= 10;
		}
		return total;
	}
}
