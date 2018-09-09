package findcommonancestor;

import java.util.Arrays;

/**
 * @author qlibin@gmail.com
 *         Created on 1/26/15.
 */
public class TestMyFindCommonAncestor {

	public static void main(String[] args) {

		test1();
		test2();
		test3();

	}

	private static void test1() {

		String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
		System.out.println("commits = " + Arrays.toString(commits));
		String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};
		System.out.println("parents = " + Arrays.toString(parents));
		String commit1 = "E";
		String commit2 = "B";

		MyFindCommonAncestor findCommonAncestor = new MyFindCommonAncestor();

		String result = findCommonAncestor.findCommonAncestor(commits, parents, commit1, commit2);

		System.out.println("result = " + result);

	}

	private static void test2() {

		String[] commits = {"N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
		System.out.println("commits = " + Arrays.toString(commits));
		String[][] parents ={{"M"},{"J", "K"}, {"H"}, {"G", "L"}, {"I"}, {"E"}, {"D"}, {"F"}, {"D"}, {"C"}, {"C"}, {"B"}, {"A"}, null};
		System.out.println("parents = " + Arrays.toString(parents));
		String commit1 = "A";
		String commit2 = "B";

		MyFindCommonAncestor findCommonAncestor = new MyFindCommonAncestor();

		String result = findCommonAncestor.findCommonAncestor(commits, parents, commit1, commit2);

		System.out.println("result = " + result);

	}

	private static void test3() {

		String[] commits = {"N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C"};//, "B", "A"};
		System.out.println("commits = " + Arrays.toString(commits));
		String[][] parents ={{"M", "L"},{"J", "K"}, {"H"}, {"G"}, {"I"}, {"E"}, {"D"}, {"F"}, {"D"}, {"C"}, {"C"}, null};// {"B"}, {"A"}, null};
		System.out.println("parents = " + Arrays.toString(parents));
		String commit1 = "C";
		String commit2 = "C";

		MyFindCommonAncestor findCommonAncestor = new MyFindCommonAncestor();

		String result = findCommonAncestor.findCommonAncestor(commits, parents, commit1, commit2);

		System.out.println("result = " + result);

	}

}
