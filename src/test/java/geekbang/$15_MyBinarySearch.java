package geekbang;

import org.junit.Test;

/**
 * Created by Administrator on 2018/11/25.
 */
public class $15_MyBinarySearch {


    @Test
    public void name() throws Exception {

        int value = 19;
//        int value = 18;
        int[] a = new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        int result = binarySearch(a, value);

        System.out.println(result);
    }

    private int binarySearch(int[] a, int value) {
        int left = 0;
        int right = a.length - 1;


        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
