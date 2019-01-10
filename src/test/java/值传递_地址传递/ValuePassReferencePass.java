package 值传递_地址传递;

import org.junit.Test;

/**
 * Created by robin on 19/1/8.
 */
public class ValuePassReferencePass {


    @Test
    public void name() throws Exception {
        Integer a = 1;
        Integer b = 2;

        System.out.println(String.format("a->%s, b->%s", a, b));
        swap(a, b);
        System.out.println(String.format("a->%s, b->%s", a, b));


//        String a1 = "a";
//        String b1 = "b";
//        System.out.println(String.format("a1->%s, b1->%s", a1, b1));
//        swap(a1, b1);
//        System.out.println(String.format("a1->%s, b1->%s", a1, b1));
        if( a ==b ^ a+1 == b) {
            System.out.println("亦或");
        }
        if( a ==b ^ a == b) {
            System.out.println("亦或2");
        }

    }

    private void swap(Integer x, Integer y) {
        Integer tmp = x;
        x = y;
        y = tmp;
    }


    private void swap(String x, String y) {
        String tmp = x;
        x = y;
        y = tmp;
    }

}
