package algo.$1_double_pointer;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

/**
 * 两数之和(已经从小到大排好序)
 * Leetcode ：167. Two Sum II - Input array is sorted (Easy)
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * <p>
 * 思路: 双指针
 * 小数指针 + 大数指针
 * 小数从头遍历, 大数从尾遍历
 * <p>
 * 如果 2个指针元素 sum = target, 返回结果
 * 如果 sum > target, 移动大指针, 使sum变雄安
 * 如果 sum < target, 返回结果
 */
public class $1_TwoSum {

    private int[] arr = null;
    private int target = 0;

    @Before
    public void setUp() throws Exception {
        arr = new int[]{2, 7, 11, 15};
        target = 9;
    }

    @Test
    public void testTwoSum() {

        int[] ints = this.twoSum(arr, target);
        System.out.println(JSON.toJSONString(ints));
    }


    public int[] twoSum(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == target) {
                return new int[]{arr[i], arr[j]};
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
