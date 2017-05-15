package contest32;

import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 5/14/17
 * @description
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[]nums1 = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums1);
        int l = 0,r = nums.length-1;
        while(l<=r){
            if(nums1[l] == nums[l]){
                l++;
            }else{
                break;
            }
        }
        while(l<=r){
            if(nums1[r] == nums[r]){
                r--;
            }else{
                break;
            }
        }
        return r - l + 1;
    }
}
