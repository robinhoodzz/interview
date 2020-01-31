package $01_array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/12/29.
 */
public class LeetCode_26_删除排序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[slow] < nums[i]) {
                slow++;
                nums[slow] = nums[i];
            }
        }
        return slow + 1;

    }

    @Test
    public void name() throws Exception {
        int[] arr = new int[]{1, 1, 2};
        Assert.assertEquals(2, this.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Assert.assertEquals(5, this.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
