import java.util.Arrays;
import java.util.Comparator;

/**
 * @author boyang.lby
 * @date 5/17/17
 * @description
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return nums;
        }
        Integer[]ni = new Integer[nums.length];
        for(int i=0;i<ni.length;i++){
            ni[i] = i;
        }
        Arrays.sort(ni,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
        });
        int l = 0,r = nums.length - 1;
        int[]ret = new int[2];
        while(l < r){
            if(nums[ni[l]] + nums[ni[r]] == target) {
                ret[0] = ni[l];
                ret[1] = ni[r];
                break;
            }else if (nums[ni[l]] + nums[ni[r]] < target){
                l++;
            }else{
                r--;
            }
        }
        return ret;
    }
}
