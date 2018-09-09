package findarray;

public class MyFindArray implements FindArray {

	public int findArray(int[] array, int[] subArray) {
		if (array == null || subArray == null || subArray.length == 0 || array.length == 0 || subArray.length > array.length)
			return -1;
		for (int i = 0, j = 0; i < array.length; i++) {
			if (j == 0 && array.length - i < subArray.length) {
				return -1;
			}
			if (array[i] == subArray[j]) {
				if (++j == subArray.length) {
					return i - j + 1;
				}
			} else {
				j = 0;
			}
		}
		return -1;
	}

}
