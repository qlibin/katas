package belltelecom.MyPackage;

import java.util.*;

/**
 * @author qlibin@gmail.com
 *         Created on 2/17/15.
 */
public class P1 {
	public static void main(String[] args) {
/*
		Set<Integer> numbers = new LinkedHashSet<Integer>(Arrays.asList(1, 2, 3, 4));

		for (Integer i : numbers) {

			if (i % 2 == 0) numbers.remove(i);

		}

		System.out.println(numbers);
*/
/*
		SomeObject o1 = new SomeObject();
		o1.someValue=2;
		SomeObject o2 = new SomeObject();
		o2.someValue=2;
		SomeObjectComparator someObjectComparator = new SomeObjectComparator();
		System.out.println(someObjectComparator.compare(o1, o2));
*/
/*
		Set<Integer> numbers = new HashSet<Integer>(Arrays.asList(1, 2, 3));

		Set<Integer> unmodifiable = Collections.unmodifiableSet(numbers);

		numbers.remove(1);

		System.out.println(unmodifiable);
*/

		test(new ArrayList<Integer>());

		test(new LinkedHashSet<Integer>());

		test(new TreeSet<Integer>());



	}
	public static void test(Collection<Integer> c) {

		c.add(3);

		c.add(2);

		c.add(1);

		c.add(2);

		c.remove(3);

		System.out.println(c);

	}
}

class SomeObject {

	int someValue;

}



class SomeObjectComparator implements java.util.Comparator<SomeObject> {

	public int compare(SomeObject o1, SomeObject o2) {

		return o1.someValue - o2.someValue;

	}

}

