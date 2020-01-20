package algo_2.$3_priority_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 * 239. Sliding Window Maximum
 * Created by Administrator on 2019/9/14.
 */
public class $10_SlidingWindowMaximum {
    /*
    解决方案
    1. 大顶堆
    2. 直接用双端队列, 并维护, 小的删去, 留最大的
     */

    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }

        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.peek();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }

        }
        return r;
    }
}
