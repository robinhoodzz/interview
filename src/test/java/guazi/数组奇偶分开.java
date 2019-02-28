package guazi;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by robin on 19/2/25.
 */
public class 数组奇偶分开 {

    @Test
    public void name() throws Exception {
        int a[] = new int[]{2, 3, 5, 6, 8, 9};
        /** 偶数在前, 奇数在后 */
//        this.splitOddAndEven(a);
        this.splitOddAndEven2(a);

        System.out.println(Arrays.toString(a));
    }

    private void splitOddAndEven(int[] a) {
        int i = 0;
        int j = 1;

        while (i < j && j < a.length) {
            while (i < a.length - 1 && a[i] % 2 == 0) {
                i++;
            }
            j = i + 1;
            while (j < a.length - 1 && a[j] % 2 != 0) {
                j++;
            }

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j++;
        }
    }


    private void splitOddAndEven2(int[] a) {
        int i = 0;
        int j = a.length - 1;

//        while (i <= j && i < a.length && j < a.length) {
        while (i <= j) {

            while (i < a.length && a[i] % 2 == 0) {
                i++;
            }

            while (j >= 0 && a[j] % 2 != 0) {
                j--;
            }

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }

    }
}