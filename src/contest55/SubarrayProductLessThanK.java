package contest55;

/**
 * @author boyang.lby
 * @date 10/22/17
 * @description
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0 || k == 1){
            return 0;
        }
        int start = 0;
        int sum = nums[0];
        int ret = 0;
        for(int i=1;i<=nums.length;i++){
            while(sum >=k){
                sum = sum / nums[start];
                start++;
            }

            ret += i - start;
            if(i<nums.length){
                sum *= nums[i];
            }
        }
        return ret;
    }
}
