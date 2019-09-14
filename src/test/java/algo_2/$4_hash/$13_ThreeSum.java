package algo_2.$4_hash;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * 三数之和
 * 15. 3Sum
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * Created by Administrator on 2019/9/14.
 */
public class $13_ThreeSum {

    /*
    思路:
    1. 暴力 a,b,c -> 3层循环, 时间O(N^3)
    2. c = -(a+b)  ->  set  时间O(1)
       a,b -> 2层循环, 时间 O(N)

    3. sort and find
       先排序 O(NlogN)
       对a循环 和 左右双指针法, 时间O(N^2)
       比上面更省空间, 但是会修改输入的值
     */

    @Test
    public void testThreeSum() throws Exception {

        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(JSON.toJSONString(lists));
    }

    public List<List<Integer>> threeSum(int[] a) {
        if (a == null || a.length == 0 || a.length < 3) {
            return null;
        }
        Arrays.sort(a);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < a.length - 2; i++) {
            if (i >= 1 && a[i] == a[i - 1]) {
                continue;
            }
            // 很重要, 在这里才需要Map/Set
            Map<Integer, Integer> d = new HashMap<>();
            for (int j = i + 1; j < a.length; j++) {
                if (!d.containsKey(a[j])) {
                    d.put(-a[i] - a[j], 1);
                } else {
                    list.add(Arrays.asList(a[i], -a[i] - a[j], a[j]));
                }
            }
        }
        return list;
    }
}
