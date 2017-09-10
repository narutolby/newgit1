package contest49;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.

 Example 1:
 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 Example 2:
 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[]dp = new int[nums.length];
        Arrays.fill(dp,1);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map1.put(i,1);
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        map1.put(i,map1.get(j));
                        map.put(dp[i],map.getOrDefault(dp[i],0) + 1);
                    }else if(dp[j] + 1 == dp[i]){
                        map.put(dp[i],map.getOrDefault(dp[i],0) + 1);
                        map1.put(i,map1.get(i) + map1.get(j));
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int ret = 0;
        for(int i =0;i<dp.length;i++){
            if(dp[i] == max){
                ret += map1.get(i);
            }else if(dp[i] > max){
                max = dp[i];
                ret = map1.get(i);
            }
        }

        return ret;
    }
    public static void main(String[]args){
        new NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1,3,5,4,7});
    }
}
