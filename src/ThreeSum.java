import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 5/17/17
 * @description
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return retList;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<=len-3;i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<=len-2;j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                for(int m=j+1;m<=len-1;m++){
                    if(m != j+1 && nums[m] == nums[m-1]) continue;
                    if(nums[i] + nums[j] + nums[m] == 0){
                        List<Integer> tmpList = new ArrayList<Integer>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[m]);
                        retList.add(tmpList);
                    }
                }
            }
        }
        return retList;
    }
}
