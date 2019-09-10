package algo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 归并2个有序数组
 * 88. Merge Sorted Array (Easy)
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * 把归并结果存到第一个数组上
 *
 * 思路: 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
 * 注意 m值 n值 是有用的
 */
public class $5_MergeSortedArray {

    int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[]{2, 5, 6};

    @Test
    public void testMerge() {
        merge(nums1, 3, nums2, 3);
        System.out.println(JSON.toJSONString(nums1));
    }

    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            } else if (j < 0) {
                nums1[k--] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
