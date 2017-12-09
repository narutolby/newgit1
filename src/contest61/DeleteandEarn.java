package contest61;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 12/3/17
 * @description
 */
public class DeleteandEarn {
    int ret = 0;
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0) + 1);
            set.add(i);
        }
        int[]u = new int[set.size()];
        int index = 0;
        for(Integer i : set){
            u[index++] = i;
        }
        dfs(map,u,0,0);
        return ret;
    }

    void dfs(Map<Integer,Integer> map,int[]u,int i,int r){
        if(i == u.length){
            ret = Math.max(r,ret);
            return;
        }
        Map<Integer,Integer> tmp = new HashMap<>();
        tmp.putAll(map);
        int tmpr = r;
        if(u[i] * map.getOrDefault(u[i],0) < map.getOrDefault(u[i]-1,0))
        r += map.getOrDefault(u[i], 0) * u[i];
        map.remove(u[i]);
        map.remove(u[i] - 1);
        map.remove(u[i] + 1);
        dfs(map,u,i+1,r);
        dfs(tmp,u,i+1,tmpr);
    }
    public static void main(String[]args){
        new DeleteandEarn().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
    }
}
