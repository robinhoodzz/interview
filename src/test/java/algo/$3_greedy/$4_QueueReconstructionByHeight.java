package algo.$3_greedy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高和序号组队
 * 406. Queue Reconstruction by Height(Medium)
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 题目描述：一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 */
public class $4_QueueReconstructionByHeight {
    /*
    为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，
    否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。

    身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
     */

    /*
    System.arrayCopy的使用
    本例中使用了 从index 往后移动的概念

    在index=0位置,插入9
    第一步 0 1 2 3 ^ ^
    第二步 ^ 0 1 2 3 ^
    第三步 9 0 1 2 3 ^

    System.arraycopy(a, i, a, i + 1, a.length - i)
    原数组      a
    开始位置    i            = 0
    目标数组    a
    目标开始位置 i+1          = 1
    目标结束位置 a.length-i   = 6


     */


    private int[][] a = new int[][]{new int[]{7, 0}, new int[]{4, 4}, new int[]{7, 1}, new int[]{5, 0}, new int[]{6, 1}, new int[]{5, 2}};

    @Test
    public void testQueueReconstruct() {
        int[][] ints = queueReconstruct(a);



        System.out.println(JSON.toJSONString(ints));
    }

    public int[][] queueReconstruct(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return new int[0][0];
        }

        Arrays.sort(a, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]));
        System.out.println(JSON.toJSONString(a));
        List<int[]> list = new ArrayList<>();
        for(int[] b : a) {
            list.add(b[1], b);
        }

        return list.toArray(new int[list.size()][]);
    }

}
