public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0 )
            return 0;
        if(nums.length == 1){
            return 1;
        }
        int[][]dp = new int[nums.length][2];
        int ret = 0;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i][1] = Math.max(dp[j][0] + 1,dp[i][1]);
                }else if(nums[i]<nums[j]){
                    dp[i][0] = Math.max(dp[j][1] + 1,dp[i][0]);
                }
                ret = Math.max(Math.max(ret,dp[i][0]),dp[i][1]);
            }
        }
        return ret+1;
    }
}
