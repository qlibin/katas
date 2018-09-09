package interview.arrays;

import java.util.Arrays;

/**
 * Created by alibin on 3/3/15.
 *
 * How to find efficiently the minimum of an array of integers that is the maximum of other arrays?
 
 Example:
 A = [126, 110, 130]
 B = [125]
 C = [105, 115]
 
 The minimum element of array A that is the maximum of B and C is 126

 */
public class Minimax {

	public static void main(String[] args) {
/*
		int[] A = {126, 110, 130};
		int[] B = {125};
		int[] C = {105, 115};
*/
		int[] A = {126, 110, 130, 345, 847, 123};
//		int[] A = {100};
		int[] B = {25, 32, 67, 153, 57};
		int[] C = {105, 110, 37, 59, 109, 32};
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));
		System.out.println("C: " + Arrays.toString(C));
		Integer result = getMinimax(A, B, C);
		System.out.println("minimax: " + result);
		System.out.println("conditions counter: " + counter);
	}

	public static int counter = 0;

	/**
	 * n = n1 + n2 + ... + np
	 * n1*log(n1) + n2*log(n2) + ... + np*log(np) + n1
	 *
	 */
	public static Integer getMinimax(int[] minHere, int[]... lessThanMin) {
		Arrays.sort(minHere);
		for (int[] aLessThanMin : lessThanMin) {
			Arrays.sort(aLessThanMin);
		}
		for (int min : minHere) {
			boolean fail = false;
			for (int[] aLessThanMin : lessThanMin) {
				counter++;
				fail = min < aLessThanMin[aLessThanMin.length - 1];
				if (fail) break;
			}
			if (!fail) {
				return min;
			}
		}
		return null;
	}

	/**
	 * n = n1 + n2 + ... + np
	 * n1*log(n1) + n2*log(n2) + ... + np*log(np) + n
	 *
	 */
	public static Integer getMinimax_(int[] minHere, int[]... lessThanMin) {
		int[] indexes = new int[lessThanMin.length];
		Arrays.sort(minHere);
		for (int i = 0; i < lessThanMin.length; i++) {
			indexes[i] = 0;
			Arrays.sort(lessThanMin[i]);
		}
		for (int i = 0; i < minHere.length; i++) {
			Integer min = minHere[i];
			boolean fail = false;
			for (int j = 0; j < lessThanMin.length; j++) {
				for (;indexes[j] < lessThanMin[j].length;indexes[j]++) {
					counter++;
					if (min < lessThanMin[j][indexes[j]]) {
						fail = true;
						break;
					}
				}
				if (fail) break;
			}
			if (!fail) {
				return min;
			}
		}
		return null;
	}

	public static Integer getMinimaxIneffitient(int[] minHere, int[]... lessThanMin) {
		Arrays.sort(minHere);
		for (int i = 0; i < lessThanMin.length; i++) {
			Arrays.sort(lessThanMin[i]);
		}
		for (int i = 0; i < minHere.length; i++) {
			Integer min = minHere[i];
			boolean fail = false;
			for (int j = 0; j < lessThanMin.length; j++) {
				for (int k = 0;k < lessThanMin[j].length;k++) {
					counter++;
					if (min < lessThanMin[j][k]) {
						fail = true;
						break;
					}
				}
				if (fail) break;
			}
			if (!fail) {
				return min;
			}
		}
		return null;
	}

}
