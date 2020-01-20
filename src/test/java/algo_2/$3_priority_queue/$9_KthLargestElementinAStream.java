package algo_2.$3_priority_queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 第K个大的元素, 在数组中和流处理中
 * 703. Kth Largest Element in a Stream
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Created by Administrator on 2019/9/14.
 */
public class $9_KthLargestElementinAStream {

    /*
    实现方式
    1. 保存K个元素, 然后排序, 每次进入新数据都再次排序, 淘汰超过N的. 时间复杂度 O(NlogK)
    2. 使用小顶堆, 长度为K, 维护了最小的K个数, 最顶就是要的数据. 时间复杂度 O(logK)
     */

    private PriorityQueue<Integer> q = null;
    private int k = 0;

    @Test
    public void testKthLargestElementinAStream() throws Exception {
        KthLargest(3, new int[]{4, 5, 8, 2});
        Assert.assertEquals(4, add(3));
        Assert.assertEquals(5, add(5));
        Assert.assertEquals(5, add(10));
        Assert.assertEquals(8, add(9));
        Assert.assertEquals(8, add(4));
    }

    public void KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a) {
            add(n);
        }
    }

    public int add(int n) {
        if (q.size() < k) {
            q.offer(n);
        } else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }

}
