import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 1/6/18
 * @description
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k){
                return true;
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
