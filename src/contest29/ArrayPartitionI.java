package contest29;

import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 4/23/17
 * @description
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            if(i%2 == 0){
                ret += nums[i];
            }
        }
        return ret;
    }

    public static void main(String[]args){
        new ArrayPartitionI().arrayPairSum(new int[]{1,4,3,2});
    }
}
