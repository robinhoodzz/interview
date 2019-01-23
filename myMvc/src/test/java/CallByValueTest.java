import org.junit.Test;

/**
 * Created by robin on 19/1/22.
 */
public class CallByValueTest {

    private StringBuilder sb1 = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();

    @Test
    public void testCallByValue() throws Exception {

        int x = 10;
        int y = 20;

        swap(x, y);


        System.out.println("x: " + x);
        System.out.println("y: " + y);

        System.out.println("---");

        System.out.println("sb1: " + sb1.hashCode());
        System.out.println("sb2: " + sb2.hashCode());

        swap(sb1, sb2);

        System.out.println("sb1: " + sb1.hashCode());
        System.out.println("sb2: " + sb2.hashCode());

        System.out.println();
        System.out.println();


        add(x, y);

        System.out.println("x: " + x);
        System.out.println("y: " + y);

        System.out.println();


        System.out.println("sb1: " + sb1.toString());
        System.out.println("sb2: " + sb2.toString());

        add(sb1, sb2);

        System.out.println("sb1: " + sb1.toString());
        System.out.println("sb2: " + sb2.toString());
    }


    private void swap(StringBuilder a, StringBuilder b) {
        StringBuilder tmp = a;
        a = b;
        b = tmp;
        System.out.println("a: " + a.hashCode());
        System.out.println("b: " + b.hashCode());
    }

    private void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    private void add(int a, int b) {
        a++;
        b++;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }


    private void add(StringBuilder a, StringBuilder b) {
        a.append("a");
        b.append("b");


        System.out.println("a: " + a.toString());
        System.out.println("b: " + b.toString());
    }

}
