package belltelecom;

/**
 * @author qlibin@gmail.com
 *         Created on 2/17/15.
 */
public class Outer {

	public String name = "Outer";

	public static void main(String[] args) {
		Inner i = new Inner();
		i.showName();
	}

	private static class Inner {
		String name = "Inner";
		void showName() {
			System.out.println(name);
		}
	}

}
