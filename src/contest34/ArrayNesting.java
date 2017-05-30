package contest34;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 5/28/17
 * @description
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ret = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(i)){
                continue;
            }
            //dfs(nums,map,i,0);
            int start = i;
            int level = 0;
            map.put(i,0);
            while(nums[start]!=i){
                level++;
                map.put(nums[start],level);
                start = nums[start];
            }
            ret = Math.max(ret,level - map.get(i) + 1);
        }
        return ret;
    }

    public static void main(String[]args){
        new ArrayNesting().arrayNesting(new int[]{5,4,0,3,1,6,2});
    }

}
