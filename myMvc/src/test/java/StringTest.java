import org.junit.Test;

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

}
