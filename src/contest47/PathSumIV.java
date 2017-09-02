package contest47;

import java.util.HashMap;
import java.util.Map;

public class PathSumIV {
    public int pathSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ret = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums){
            int key = num / 10;
            int value = num % 10;
            int h = num / 100;
            int t = num / 10 % 10;
            t = t % 2 == 0 ? t / 2 : (t + 1) / 2;
            int parent = (h - 1) * 10 + t;
            if(h == 1){
                map.put(key,value);
            }else{
                map.put(key,map.get(parent) + value);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int left = (entry.getKey() / 10  + 1) * 10 + entry.getKey() % 10 * 2 - 1;
            int right = (entry.getKey() / 10  + 1) * 10 + entry.getKey() % 10 * 2 ;
            if(!map.containsKey(left) && !map.containsKey(right)){
                ret += entry.getValue();
            }
        }
        return ret;
    }
    public static void main(String[]args){
        new PathSumIV().pathSum(new int[]{113,215,221});
    }
}
