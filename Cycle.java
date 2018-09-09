import java.util.*;

/**
 * @author qlibin@gmail.com
 *         Created on 2/17/15.
 */
public class Cycle {
	public static void main(String args[]) {

		double a=2, b = 4, c = -1;
		printRoots(a, b, c);

		printNumber(10);

		System.out.println(single(1, 2, 1, 4, 2, 6, 6));

	}

	static void printRoots(double a, double b, double c) {

		double x1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
		double x2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);

		System.out.println(x1);
		System.out.println(x2);

	}

	static void printNumber(int i) {
		if (i > 1) printNumber(i - 1);
		System.out.println(i);
	}

	static int single(Integer... numbers) {
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length/2; i++) {
			if (!numbers[i * 2].equals(numbers[i * 2 + 1])) {
				return numbers[i*2];
			}
		}
		throw new IllegalArgumentException("Wrong input data");
	}


}
