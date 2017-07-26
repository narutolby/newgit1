package Contest38;

import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 6/25/17
 * @description
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len-1] * nums[len-2] * nums[len - 3],nums[0] * nums[1] * nums[len-1]);
    }
}
