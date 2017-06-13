package contest36;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author boyang.lby
 * @date 6/11/17
 * @description
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ret = 0;
        Arrays.sort(nums);
        for(int j=nums.length - 1;j>=2;j--){
            int target = nums[j];
            int x = 0,y = j - 1;
            while(x<y){
                if(nums[x]+nums[y]>target){
                    ret += (y-x);
                    y--;
                }else if(nums[x]+nums[y]<=target){
                    x++;
                }
            }
        }
        return ret;
    }
}
