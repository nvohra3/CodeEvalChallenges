package EasyLevelChallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.codeeval.com/open_challenges/62/
 */
public class NModM {
	public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File(args[0]));
        while (file.hasNextLine())
        {
        	String[] line = file.nextLine().split(",");
        	int n = Integer.parseInt(line[0]);
        	int m = Integer.parseInt(line[1]);
        	System.out.println(mod(n, m));
        }
        file.close();
	}

	/**
	 * @param n dividend
	 * @param m divisor
	 * @return n % m (the remainder of the divison operation n / m)
	 */
	private static int mod(int n, int m) {
		if (n > 0)
			while (n >= m)
    			n -= m;
		else if (n < 0)
			while (n <= m)
    			n += m;
    	// If n = 0, method just returns 0
		return n;
	}
}
