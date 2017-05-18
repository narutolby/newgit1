package indeed.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author boyang.lby
 * @date 5/17/17
 * @description
 */
public class ThreeSum1 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return retList;
        }
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int l = i+1,r = nums.length-1;
            while(l<r){
                if(nums[l] + nums[r] + nums[i] == 0){
                    retList.add(Arrays.asList(nums[l],nums[r],nums[i]));
                    while(l < r && nums[l] == nums[l+1]){l++;}
                    while(l < r && nums[r] == nums[r-1]){r--;}
                    l++;
                    r--;
                }else if(nums[l] + nums[r] < 0 - nums[i]){
                    while(l < r &&nums[l] == nums[l+1]){l++;}l++;
                }else{
                    while(l < r &&nums[r] == nums[r-1]){r--;}r--;
                }


            }
        }
        return retList;
    }
}
