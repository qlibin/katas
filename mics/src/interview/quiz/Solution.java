package interview.quiz;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by alibin on 4/12/15.
 *
 * @author alibin
 */
public class Solution {

	public static void main(String[] args) {

//		fileReadExample();
		int[] a = new int[] {1, 1, 3, 4, 5, 2, 3, 2, 5};
		System.out.println("sorting: " + someThing(a));
		System.out.println("memory: " + someThing2(a));

	}

	private static int someThing(int[] a) {

		long start = System.nanoTime();
		Arrays.sort(a);
		for (int i = 0; i < a.length-1; i+=2) {
			if (a[i] != a[i+1]) {
				System.out.println("time: " + (System.nanoTime() - start));
				return a[i];
			}
		}
		System.out.println("time: " + (System.nanoTime() - start));
		throw new IllegalStateException();

	}

	private static int someThing2(int[] a) {

		long start = System.nanoTime();
		Set<Integer> mem = new HashSet<Integer>(a.length/2);
		for (int i = 0; i < a.length; i++) {
			if (!mem.contains(a[i])) {
				mem.add(a[i]);
			} else {
				mem.remove(a[i]);
			}
		}
		System.out.println("time: " + (System.nanoTime() - start));
		return mem.iterator().next();

	}

	private static void fileReadExample() {

		String filename = "mics/resources/datafile";

		try {

			InputStream is = new FileInputStream(filename);
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader br = new BufferedReader(isr);
//			BufferedReader br = Files.newBufferedReader(new File(filename).toPath(), Charset.defaultCharset());

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void stdInExample() {
		Scanner scanner = new Scanner(System.in);

		while (!Thread.currentThread().isInterrupted()) {

			System.out.print("Type a number of pairs (0 to exit): ");
			int n = scanner.nextInt();

			if (n == 0) {
				System.out.print("bye");
				System.exit(0);
				return;
			}

			for (int i = 0;
				 i < n;
				 i++) {
				System.out.print(String.format("(%d/%d) Type two numbers to get a sum: ", i+1, n));
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				System.out.println(String.format("sum: %d", a + b));
			}

		}
	}

}
