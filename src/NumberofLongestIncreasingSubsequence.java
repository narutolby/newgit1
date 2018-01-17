import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return 1;
        }
        int[]count = new int[len];
        int[]dp = new int[len];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max = 1t ;
        for(int i=1;i<len;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j] + 1;
                        max = Integer.max(dp[i],max);
                        count[i] = count[j];
                    }else if(dp[i] == dp[j] + 1){
                        count[i] += count[j];
                    }
                }
            }
        }
        int ret = 0;
        for(int i=0;i<dp.length;i++){
            if(dp[i] == max){
                ret += count[i];
            }
        }
        return ret;
    }
}
