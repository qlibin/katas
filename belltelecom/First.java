package belltelecom;

/**
 * @author qlibin@gmail.com
 *         Created on 2/17/15.
 */
public class First extends Base {

	public static void main(String[] args) {
		First a = new First();
		a.amethod();
	}

	public void  myFunc() {
		System.out.println("My-Func");
	}

	public void amethod() {
		myFunc();
	}

}

abstract class Base {
	abstract public void  myFunc();
	public void another() {
		System.out.println("Another method");
	}
}
