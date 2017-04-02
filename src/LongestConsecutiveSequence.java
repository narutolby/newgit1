import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 3/21/17
 * @description
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            int mid = nums[i];
            if(!set.contains(mid)){
                continue;
            }
            int tmp = 0;
            int left = mid - 1;
            int right = mid + 1;
            tmp++;
            set.remove(mid);
            while(set.contains(left)){
                set.remove(left);
                tmp++;
                left--;
            }
            while(set.contains(right)){
                set.remove(right);
                tmp++;
                right++;
            }
            ret = Math.max(ret,tmp);
        }
        return ret;

    }
}
