package contest56;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 10/29/17
 * @description
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        int[]bucket = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                bucket[diff]++;
            }
        }
        for(int i:bucket){
            if(k>i){
                k -= i;
            }else{
                return i;
            }
        }
        return 0;
    }
    public static void main(String[]args){
        new FindKthSmallestPairDistance().smallestDistancePair(new int[]{1,6,1},3);
    }
}
