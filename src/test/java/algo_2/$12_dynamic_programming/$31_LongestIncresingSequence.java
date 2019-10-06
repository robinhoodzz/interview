package algo_2.$12_dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 最大上升序列
 * 300
 * 10 9 2 5 3 7 101 18 20
 * 应得出 2 3 7 18 20
 * <p>
 * <p>
 * <p>
 * Created by Administrator on 2019/10/6.
 */
public class $31_LongestIncresingSequence {

    /*
    DP状态定义
        dp[i]: 从头 -> i元素, 最长子序列的长度
        然而并不是  dp[i-1]最大就行
        需要从 dp[0], dp[1] ... dp[i-1] 加起来最大才行
        时间复杂 O(N^2)

    二分搜索法 时间复杂 O(NlogN)
        维护一个由二分搜索得出的数组, 后面的值大追加, 值小替换
        [10]
        [9]
        [2]
        [2,5]
        [2,3]
        [2,3,7]
        [2,3,7,101]
        [2,3,7,18]
        [2,3,7,18,20]

     */

    @Test
    public void testLongest() throws Exception {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 20};
        int result = longest(arr);

        Assert.assertEquals(5, result);

    }

    public int longest(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
//            int index = Collections.binarySearch(list, arr[i]);
            int index = this.binarySearch(list, arr[i]);
            if (index == list.size()) {
                list.add(arr[i]);
            } else if(list.get(index) > arr[i]){
                list.set(index, arr[i]);
            } else {
                list.add(arr[i]);
            }
            System.out.println(list.toString());
        }

        return list.size();
    }

    public int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (list.get(mid) == target) return mid;
            else if (list.get(mid) < target) l = mid + 1;
            else r = mid - 1;
        }
        return (r - l) / 2 + l;
    }
}
