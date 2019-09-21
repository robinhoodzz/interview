package algo_2.$9_binary_search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 先升后降数组找最大值
 * Given an array of integers. Find a peak element in it.
 * An array element is peak if it is larger than its neighbors.
 * For corner elements, we need to consider only one neighbor.
 * For example, for input array {5, 10, 20, 15}, 20 is the only peak element.
 * For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90.
 * Note that we need to return any one peak element.
 * 二分一次找中点, 如果中点arr[mid] 比 arr[mid-1], arr[mid+1]都大, 那么就返回mid
 * 如果 arr[mid] > arr[mid-1], 则最大值在mid右边, 上升趋势
 * 如果 arr[mid] < arr[mid+1], 则最大值在mid左边, 下降趋势
 * <p>
 * Created by Administrator on 2019/9/21.
 */
public class $0_PeakInAGivenArray {


    @Test
    public void testPeakInAGivenArray() throws Exception {
        int[] arr = new int[]{1, 5, 10, 20, 15, 8, 2};
        int result = peakInAGivenArray(arr);
        Assert.assertEquals(20, result);
    }


    public int peakInAGivenArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length < 2) return arr[0];

        int l = 0, r = arr.length - 1, mid = 0;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[r = mid + 1]) {
                return arr[mid];
            } else if (arr[mid] > arr[mid + 1]) { // 处于下坡段
                r = mid - 1;
            } else if (arr[mid] < arr[mid - 1]) { // 处于上坡段
                l = mid + 1;
            }
        }


        return arr[mid];
    }
}
