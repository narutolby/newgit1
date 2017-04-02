import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 3/21/17
 * @description
 */
public class LongestConsecutiveSequenceII {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                int n = nums[i];
                int left = map.containsKey(n-1) ? map.get(n-1) : 0;
                int right = map.containsKey(n+1) ? map.get(n+1) : 0;
                int sum = left + right + 1;
                map.put(n,sum);
                ret = Math.max(ret,sum);
                map.put(n-left,sum);
                map.put(right,sum);
            }
        }
        return ret;
    }
}
