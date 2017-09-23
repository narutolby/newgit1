/**
 * @author boyang.lby
 * @date 9/21/17
 * @description
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ret = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            ret = Math.max(sum,ret);
            if(sum < 0){
                sum = 0;
            }
        }
        return ret;
    }
}
