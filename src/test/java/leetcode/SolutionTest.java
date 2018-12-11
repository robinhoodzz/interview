package leetcode;

import com.leetcode.array.Solution;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/12/9.
 */
public class SolutionTest {

    @Test
    public void name() throws Exception {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(solution.pivotIndex(arr));
    }


    @Test
    public void name2() throws Exception {
        Solution solution = new Solution();
//        int[] arr = new int[]{0, 0, 0, 1};
//        int[] arr = new int[]{0, 0, 2, 1};
        int[] arr = new int[]{0, 0, 2, 3};
        System.out.println(solution.dominantIndex(arr));
    }


    @Test
    public void name3() throws Exception {
        Solution solution = new Solution();
//        int[] arr = new int[]{0, 0, 0, 1};
//        int[] arr = new int[]{0, 0, 2, 1};
        int[] arr = new int[]{9, 9};
        System.out.println(Arrays.toString(solution.plusOne(arr)));
    }


    @Test
    public void name4() throws Exception {
        Solution solution = new Solution();
//        int[] arr = new int[]{0, 0, 0, 1};
//        int[] arr = new int[]{0, 0, 2, 1};
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(solution.findDiagonalOrder(arr)));
    }




    @Test
    public void name5() throws Exception {
        Solution solution = new Solution();
        String a = "11";
        String b = "1" ;
        System.out.println(solution.addBinary(a,b));
    }


}
