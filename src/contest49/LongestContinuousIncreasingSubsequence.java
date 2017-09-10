package contest49;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int ret = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                ret = Math.max(ret,tmp);
                tmp = 0;
            }else{
                tmp++;
            }
        }
        return Math.max(ret,tmp);
    }
}
