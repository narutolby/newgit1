/**
 * @author boyang.lby
 * @date 5/15/17
 * @description
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length < 2){
            return nums[0];
        }
        int[]dp = new int[nums.length];
        int[]dp1 = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = dp[0];
        int len = nums.length;
        for(int i=2;i<len-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        dp1[0] = 0;
        dp1[1] = nums[1];
        for(int i=2;i<len;i++){
            dp1[i] = Math.max(dp1[i-1],dp1[i-2] + nums[i]);
        }
        return Math.max(dp[nums.length-2],dp1[nums.length-1]);
    }
}
