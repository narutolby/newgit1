import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        Set<Integer> set = new HashSet<Integer>();
        int[]ret = new int[2];
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                ret[0] = nums[i];
            }
            sum+= nums[i];
        }
        ret[1] = (1 + nums.length) * nums.length / 2 - sum + ret[0];
        return ret;
    }
}
