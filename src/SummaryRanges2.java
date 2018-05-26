import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 Example 1:

 Input:  [0,1,2,4,5,7]
 Output: ["0->2","4->5","7"]
 Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 Example 2:

 Input:  [0,2,3,4,6,8,9]
 Output: ["0","2->4","6","8->9"]
 Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class SummaryRanges2 {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0){
            return Collections.EMPTY_LIST;
        }
        List<String> result = new ArrayList<>();
        int start = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] - nums[i-1] !=1){
                if(i-1 == start){
                    result.add(String.valueOf(nums[start]));
                }else{
                    result.add(nums[start] + "->" + nums[i-1]);
                }
                start = i;
            }
        }
        result.add(start == nums.length -1 ? nums[start]+"" : nums[start] + "->" + nums[nums.length-1]);
        return result;
    }
}
