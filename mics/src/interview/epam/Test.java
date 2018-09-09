package interview.epam;

import java.util.*;

/**
 * Created by alibin on 3/6/15.
 */
public class Test {

	public static void main(String[] args) {

/*
		char c = 'e';

		System.out.println(c);

		int c2 = (int)0;

		System.out.println(((char)(0-1)));
		char c3 = (char)c2;
		System.out.println(c3);
*/

		char[] tchars = {0, (char)(0-1), Character.MAX_VALUE/*, (char)secret*/};
		String terminalString = new String(tchars);

//		List<String> input = Arrays.asList("this", "is", "test");
		List<String> input = Arrays.asList("this", "is", "test", terminalString);
		System.out.format("input list of strings: %s\n", Arrays.toString(input.toArray()));
		String encoded = encode(input);
		System.out.format("encoded string: %s\n", encoded);
		List<String> result = decode(encoded);
		System.out.format("decoded list: %s\n", Arrays.toString(result.toArray()));

		Iterator<String> it = result.iterator();
		boolean equals = true;
		for (String inputStr : input) {
			String decodedStr = it.next();
			if (!inputStr.equals(decodedStr)) {
				equals = false;
				break;
			}
		}
		System.out.format("Decode %s\n", equals?"succeeded":"failed");


	}

	public static final short secret = (short)Character.MAX_VALUE-1;

	public static String encode(List<String> input) {

		StringBuilder sb = new StringBuilder();
		for (String s : input) {
			String encodedString = encode(s);
			sb.append(encodedString).append((char)0);
		}

		return sb.toString();
	}

	private static String encode(String string) {

		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char)((short)chars[i] ^ secret);
//			chars[i] = (char)((int)chars[i] + 1);
//			if ((int)chars[i] == 0) {
//				chars[i] = (char)1;
//			}
		}
		return new String(chars);

	}

	private static List<String> decode(String encodedString) {

		List<String> result = new ArrayList<String>();
		char[] sep = {0};
		String[] encodedStrings = encodedString.split(new String(sep));
		for (String str : encodedStrings) {
			str = decodeOneString(str);
			result.add(str);
		}
		return result;

	}

	private static String decodeOneString(String string) {

		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
//			if ((int)chars[i] == 1) {
//				chars[i] = (char)0;
//			}
			chars[i] = (char)((short)chars[i] ^ secret);
//			chars[i] = (char)((int)chars[i] - 1);
		}
		return new String(chars);

	}
}
