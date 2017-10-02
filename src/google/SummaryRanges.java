package google;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 10/2/17
 * @description
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> retList = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return retList;
        }
        if(nums.length == 1){
            retList.add(nums[0]+"");
            return retList;
        }
        int start = 0,last = 1;
        while(last<=nums.length){
            if(last == nums.length || nums[last]-nums[last-1]!=1){
                if(start == last-1){
                    retList.add(nums[start]+"");
                }else{
                    retList.add(nums[start] + "->" + nums[last-1]);
                }
                start = last;
            }
            last++;
        }

        return retList;
    }
}
