import org.junit.Test;

/**
 * Created by Administrator on 2018/11/12.
 */
public class IPlusPlus {

    @Test
    public void name() throws Exception {

        int i = 0;
        int j = 0;

        j = i++;
        System.out.println(j);

        i = 0;
        j = 0;
        j = ++i;
        System.out.println(j);

        i = 0;
        j = 0;

        i = i++;
        System.out.println(i);


        i = 0;
        j = 0;

        i = ++i;
        System.out.println(i);


        System.out.println();
        for (int k = 0; k < 2; k++) {
            System.out.println(k);
        }
        System.out.println();
        for (int k = 0; k < 2; ++k) {
            System.out.println(k);
        }

    }
}
