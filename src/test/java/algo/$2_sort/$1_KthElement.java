package algo.$2_sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array (Medium)
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 */
public class $1_KthElement {
    /*
    用于求解 TopK Elements 问题，也就是 K 个最小元素的问题。可以维护一个大小为 K 的最小堆，最小堆中的元素就是最小元素。最小堆需要使用大顶堆来实现，大顶堆表示堆顶元素是堆中最大元素。这是因为我们要得到 k 个最小的元素，因此当遍历到一个新的元素时，需要知道这个新元素是否比堆中最大的元素更小，更小的话就把堆中最大元素去除，并将新元素添加到堆中。所以我们需要很容易得到最大元素并移除最大元素，大顶堆就能很好满足这个要求。

    堆也可以用于求解 Kth Element 问题，得到了大小为 k 的最小堆之后，因为使用了大顶堆来实现，因此堆顶元素就是第 k 大的元素。

    快速选择也可以求解 TopK Elements 问题，因为找到 Kth Element 之后，再遍历一次数组，所有小于等于 Kth Element 的元素都是 TopK Elements。

    可以看到，快速选择和堆排序都可以求解 Kth Element 和 TopK Elements 问题。
     */

    int[] nums = new int[]{3, 2, 1, 5, 6, 4};
    int k = 2;

    @Test
    public void testTopK() {
        int a1 = findTopKBySort(nums, k);
        Assert.assertEquals(5, a1);

        int a2 = findTopKByHead(nums, k);
        Assert.assertEquals(5, a2);

    }

    /**
     * 排序实现 时间复杂度 O(NlogN), 空间复杂度O(1)
     *
     * @param nums 数字
     * @param k    第K个元素
     * @return
     */
    public int findTopKBySort(int nums[], int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆实现 时间复杂度O(NlogK), 空间复杂度O(K)
     * @param nums
     * @param k
     * @return
     */
    public int findTopKByHead(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if(pq.size() > k) { // 维护堆大小为 k
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * 快速选择实现, 待定
     */

}
