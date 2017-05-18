import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author boyang.lby
 * @date 5/18/17
 * @description
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return retList;
        }
        Arrays.sort(nums);
        int t = target;
        int len = nums.length;
        for(int i=0;i<len-3;i++){
            for(int j=i+1;j<len-2;j++){
                int m = j+1,n = nums.length - 1;
                target = t - nums[i] - nums[j];
                while(m<n){
                    if(nums[m] + nums[n] == target){
                        retList.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        while(m < n && nums[m] == nums[m+1]){
                            m++;
                        }
                        while(m < n && nums[n] == nums[n-1]){
                            n--;
                        }
                        m++;
                        n--;
                    }else if(nums[m] + nums[n] < target){
                        m++;
                    }else{
                        n--;
                    }
                }
                while(j<len-3 && nums[j] == nums[j+1]) j++;
            }
            while(i<len-4 &&nums[i] == nums[i+1]) i++;
        }
        return retList;
    }
}
