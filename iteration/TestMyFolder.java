package iteration;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qlibin@gmail.com
 *         Created on 1/23/15.
 */
public class TestMyFolder {

	public static void main(String[] args) {

		Folder<Integer, Long> folder = new MyFolder<Integer, Long>();

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < 7; i++) {
			queue.add(i + 1);
		}

		Long result = folder.fold((long)queue.poll(), queue, new Function2<Integer, Long, Long>() {
			@Override
			public Long apply(Integer e1, Long e2) {
				System.out.format("%s + %s\n", e1, e2);
				return e1 + e2;
			}
		});

		System.out.format("Result is %s\n", result);
		System.out.format("queue size is %s\n", queue.size());

	}

}
