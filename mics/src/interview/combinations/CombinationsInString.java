package interview.combinations;

import java.util.Arrays;

/**
 * Created by alibin on 3/2/15.
 * Given a string (for example: "a?bc?def?g"), write a program to generate all the possible strings by replacing ? with 0 and 1.
 * Example:
 * Input : a?b?c?
 * Output: a0b0c0, a0b0c1, a0b1c0, a0b1c1, a1b0c0, a1b0c1, a1b1c0, a1b1c1.
 */
public class CombinationsInString {

	public static void main(String[] args) {

		String input = "a?bc?def?g";
		System.out.format("\nInput: %s\n", input);
		System.out.format("Output: %s\n", Arrays.toString(getCombinations(input)));

		input = "a?bc";
		System.out.format("\nInput: %s\n", input);
		System.out.format("Output: %s\n", Arrays.toString(getCombinations(input)));
		input = "??";
		System.out.format("\nInput: %s\n", input);
		System.out.format("Output: %s\n", Arrays.toString(getCombinations(input)));
		input = "?";
		System.out.format("\nInput: %s\n", input);
		System.out.format("Output: %s\n", Arrays.toString(getCombinations(input)));

		input = "abcdefg";
		System.out.format("\nInput: %s\n", input);
		System.out.format("Output: %s\n", Arrays.toString(getCombinations(input)));

		input = "";
		System.out.format("\nInput: %s\n", input);
		System.out.format("Output: %s\n", Arrays.toString(getCombinations(input)));

	}

	private static String[] getCombinations(String input) {
		char[] chars = input.toCharArray();
		int[] placeHolders = new int[input.length()];
		int placeHoldersCount = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '?') {
				placeHolders[placeHoldersCount++] = i;
			}
		}
		if (placeHoldersCount == 0)
			return new String[0];
		long resultCount = Math.round(Math.pow(2.0, (double)(placeHoldersCount)));
		String[] result = new String[(int)resultCount];
		for (int i = 0; i < resultCount; i++) {
			for (int j = 0; j < placeHoldersCount; j++) {
				chars[placeHolders[j]] = getBitChar(i, placeHoldersCount-1-j);
			}
			result[i] = new String(chars);
		}

		return result;
	}

	private static char getBitChar(int number, int bit) {
		return ((number >> bit) & 1) == 1?'1':'0';
	}

}
