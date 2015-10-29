package EasyLevelChallenges;

import java.io.FileNotFoundException;

/**
 * https://www.codeeval.com/open_challenges/4/
 */
public class SumOfPrimes {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(sumOfPrimes(1000));
	}

	/**
	 * @param max number of prime numbers to find sum of
	 * @return sum of first "max" prime numbers
	 */
	private static int sumOfPrimes(int max) {
		int count = 0;
		int currentNum = 2;
		int sum = 0;
		while (count < 1000)
		{
			boolean isPrime = true;
			for (int i = 2; i <= currentNum / 2; i++)
				if (currentNum % i == 0)
				{
					isPrime = false;
					break;
				}
			if (isPrime)
			{
				count++;
				sum += currentNum;
			}
			currentNum++;
		}
		return sum;
	}
}
