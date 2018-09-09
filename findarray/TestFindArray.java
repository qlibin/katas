package findarray;

import java.util.Arrays;

/**
 * @author qlibin@gmail.com
 *         Created on 1/22/15.
 */
public class TestFindArray {

	private static int passed = 0;
	private static int failed = 0;

	static void log(String msg) {
		System.out.println(msg);
	}

	private static void testIndexOfSubArray(FindArray findArray, int[] array, int[] subArray, int expected)	{
		log(String.format(">>>> Find %s in %s", Arrays.toString(subArray), Arrays.toString(array)));
		int result = findArray.findArray(array, subArray);
		System.out.format("result is %s\n", result);
		if (result != expected) {
			failed++;
			log(String.format("!!!!!  Test failed: expected result is %s\n", expected));
		} else {
			passed++;
			log("Test passed\n");
		}
	}

	public static void main(String[] args) {

		FindArray findArray = new MyFindArray();

		int
				array[] = new int[]{1, 2, 3, 4},
				subArray[] = new int[]{1, 2};

		testIndexOfSubArray(findArray, null, subArray, -1);
		testIndexOfSubArray(findArray, array, null, -1);
		testIndexOfSubArray(findArray, subArray, array, -1);
		testIndexOfSubArray(findArray, array, new int[]{}, -1);
		testIndexOfSubArray(findArray, new int[]{}, subArray, -1);

		testIndexOfSubArray(findArray, array, subArray, 0);
		testIndexOfSubArray(findArray, new int[]{1, 2, 3, 4}, new int[]{1}, 0);
		testIndexOfSubArray(findArray, new int[]{1, 2, 3, 4}, new int[]{2, 3}, 1);
		testIndexOfSubArray(findArray, new int[]{1, 2, 3, 4}, new int[]{3, 4}, 2);
		testIndexOfSubArray(findArray, new int[]{1, 2, 3, 4}, new int[]{4}, 3);

		testIndexOfSubArray(findArray, new int[]{1, 2, 3, 4}, new int[]{3, 4, 5}, -1);
		testIndexOfSubArray(findArray, new int[]{1, 2, 3, 4, 5, 6}, new int[]{3, 4, 5, 6, 7, 8}, -1);

		testIndexOfSubArray(findArray, new int[]{1, 2, 3, 4}, new int[]{4, 3}, -1);

		testIndexOfSubArray(findArray, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, 0);

		//[4,9,3,7,8] and [3,7] should return 2.
		testIndexOfSubArray(findArray, new int[]{4,9,3,7,8}, new int[]{3, 7}, 2);

		log(String.format("Tests passed: %s. Tests failed: %s\n", passed, failed));

	}

}
