package interview.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alibin on 3/4/15.
 * A program that prints all combinations of a n letter word without using recursion technique.
 Example :
 Word : abcd
 abcd
 bacd
 cabd
 acbd
 bcad
 cbad
 dbac
 bdac
 adbc
 dabc
 badc
 abdc
 acdb
 cadb
 dacb
 adcb
 cdab
 dcab
 dcba
 cdba
 bdca
 dbca
 cbda
 bcda
 */
public class Anagrams {

	public static void main(String[] args) {
		String input = "abcd";
		System.out.println("\ninput: " + input);
		List<String> result = getAnagrams(input);
		System.out.println("\noutput: ");
		for (String s : result) {
			System.out.println("\t"+s);
		}
	}

	private static List<String> getAnagrams(String input) {
		List<String> result = new ArrayList<String>();
		char[] chars = input.toCharArray();
		char[] anagram = new char[chars.length];

		int numbers[] = {0, 1, 2, 3};
//		int numbers[] = {0, 1, 2, 3};

		do {
			for (int i = 0; i < numbers.length; i++) {
				anagram[i] = chars[numbers[i]];
			}
			result.add(new String(anagram));
		} while (nextPermutation(numbers));

		return result;
	}

	private static boolean nextPermutation(int[] numbers) {
		int i1, i2, len = numbers.length;
		boolean result = false;

		/* Find the rightmost element that is the first in a pair in ascending order */
		for (i1 = len - 2, i2 = len - 1; numbers[i2] <= numbers[i1] && i1 != 0; i1--, i2--);

		if (numbers[i2] <= numbers[i1]) {
			/* If not found, array is highest permutation */
			reverse(numbers, 0);
		} else {
			/* Find the rightmost element to the right of i1 that is greater than ar[i1] */
			for (i2 = len - 1; i2 > i1 && numbers[i2] <= numbers[i1]; i2--);
	        /* Swap it with the first one */
			swap(numbers, i1, i2);
	        /* Reverse the remainder */
			reverse(numbers, i1 + 1);
			result = true;
		}

		return result;
	}

	private static void reverse(int[] numbers, int start) {
		for (int i = start, j = numbers.length - 1; i < j; i++, j--) {
			swap(numbers, i, j);
		}
	}

	private static void reverse(char[] chars, int start) {
		for (int i = start, j = chars.length - 1; i < j; i++, j--) {
			swap(chars, i, j);
		}
	}

	private static void swap(int[] numbers, int i, int j) {
		int t = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = t;
	}

	private static void swap(char[] chars, int i, int j) {
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
	}


}
