package interview.concurrency;

/**
 * Created by alibin on 10/16/15.
 *
 * @author alibin
 */
class Base {
    public static void main(String[] args) {
    System.out.println("dsfsdfd");
    }
    Base get(){
        return null;
    }
}
public class Test extends Base {

    Test get() {
        return null;

    }

    public static void main(String[] args) {
//        int[] a = {1};
        Test t = new Test();
//        t.increment(a);
//        System.out.println(a[a.length-1]);
//
//        String s1 = new String("wewe");
//        String s2 = new String("sfsdf");
//        String s3 = new String();
//        s3 = s1 + s2;
//        int q=5, w=0;
//        try {
//            q=q/w;
//        }catch (Exception e) {
//            System.out.println("ex");
//        } finally {
//            System.out.println("fin");
//        }
        Object o = "";
        int r = t.m(o);
        System.out.println("fin " + r);
    }

    int m(String s) {
        return 1;
    }
    int m(Object o) {
        return 1;
    }
    private void increment(int[] a) {
        a[a.length-1]++;
    }
}
