import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 19/1/21.
 */
public class StringTest {

    @Test
    public void name() throws Exception {

        String a = null;
        String b = "b";

        System.out.println(a + b);

    }

    @Test
    public void testFor() throws Exception {

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        System.out.println();
        for (int i = 0; i < 3; ++i) {
            System.out.println(i);
        }

    }

    @Test
    public void name2() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");

        for (String s : list) {
            System.out.println(s.hashCode());
        }

    }

    @Test
    public void testHashCode() throws Exception {

        TestObject a = new TestObject();
        TestObject b = new TestObject();
        TestObject c = a;

        a.setX(1);
        b.setX(2);
        c.setX(3);

        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println();

        System.out.println(a == c);
        System.out.println(a.equals(c));
        System.out.println();

        System.out.println(a.getX());
        System.out.println(b.getX());
        System.out.println(c.getX());
    }

    @Test
    public void testPlus() throws Exception {
        System.out.println(testPlus1());
        System.out.println(testPlus2());
    }

    private int testPlus1() {
        int a = 1;
        return a++;
    }
    private int testPlus2() {
        int a = 1;
        return ++a;
    }
}
