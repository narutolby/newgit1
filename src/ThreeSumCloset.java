import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @author boyang.lby
 * @date 5/18/17
 * @description
 */
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length - 2;i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while(l<r){
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == target) {
                    return sum;
                } else if(sum < target){
                    l++;
                }else{
                    r--;
                }
                if (diff > Math.abs(sum - target)) {
                    diff = Math.abs(sum - target);
                    ret = sum;
                }
            }
        }
        return ret;
    }
}
