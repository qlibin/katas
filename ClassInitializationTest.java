/**
 * Java program to demonstrate class loading and initialization in Java.
 */
public class ClassInitializationTest {

    public static void main(String args[]) throws InterruptedException {
  
//        NotUsed o = null; //this class is not used, should not be initialized
//        Child t = new Child(); //initializing sub class, should trigger super class initialization
 //       System.out.println((Object)o == (Object)t);
       System.out.println(Child.familyName);
//	System.out.println(isConfusing());
		String s = "1";
                System.out.format("s = \"1\"\n");
		String t = new String("1");
                System.out.format("t = new String(\"1\")\n");
		String w = "1";
                System.out.format("w = \"1\"\n");
		System.out.format("s == t is %s\n", s == t);
                System.out.format("s == w is %s\n", s == w);
                System.out.format("s == t.intern() is %s\n", s == t.intern());

    }

	static boolean isConfusing() {
		try{return true;} finally{return false;}
	}
}

/**
 * Super class to demonstrate that Super class is loaded and initialized before Subclass.
 */
class Parent {
    protected final static String familyName = "Lawson";
    static { System.out.println("static block of Super class is initialized"); }
    {System.out.println("non static blocks in super class is initialized");}
}

/**
 * Java class which is not used in this program, consequently not loaded by JVM
 */
class NotUsed {
    static { System.out.println("NotUsed Class is initialized "); }
}

/**
 * Sub class of Parent, demonstrate when exactly sub class loading and initialization occurs.
 */
class Child extends Parent {
    static { System.out.println("static block of Sub class is initialized in Java "); }
    {System.out.println("non static blocks in sub class is initialized");}
}


