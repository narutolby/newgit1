package contest33;

import java.util.HashMap;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 5/21/17
 * @description
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]+1)){
                ret = Math.max(ret,map.get(nums[i]) + map.get(nums[i]+1));
            }
        }
        return ret;
    }
}
