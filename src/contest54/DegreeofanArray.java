package contest54;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 Note:

 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        int ret = Integer.MAX_VALUE;
        int degree = 1;
        for(int i=0;i<nums.length;i++){
            List<Integer> list = null;
            if(!map.containsKey(nums[i])){
                list = new ArrayList<>();
            }else{
                list = map.get(nums[i]);
            }
            map.put(nums[i],list);
            list.add(i);
            if(degree < list.size()){
                degree = list.size();
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == degree){
                List<Integer> list = entry.getValue();
                ret = Math.min(ret,list.get(list.size()-1) - list.get(0) + 1);
            }
        }
        return ret;
    }
    public static void main(String[]args){
        new DegreeofanArray().findShortestSubArray(new int[]{1,2,2,3,1});
    }
}
