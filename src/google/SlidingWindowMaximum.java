package google;

import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 10/2/17
 * @description
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k==0){
            return new int[0];
        }
        int len = nums.length;
        int[]ret = new int[len - k + 1];
        int[] w = Arrays.copyOfRange(nums,0,k);
        Arrays.sort(w);
        int index = 0;
        ret[index++] = w[k-1];
        for(int i=k;i<len;i++){
            int add = nums[i];
            int del = nums[i-k];
            int r = Arrays.binarySearch(w, del);
            while(r+1 < k && w[r+1]<add){
                w[r] = w[r+1];
                r++;
            }
            while(r-1>=0 && w[r-1]>add){
                w[r] = w[r -1];
                r--;
            }
            w[r] = add;
            ret[index++] = w[k-1];
        }
        return ret;
    }
}
