package contest51;

import java.util.HashMap;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 9/24/17
 * @description
 */
public class RedundantConnection {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int[] findRedundantConnection(int[][] edges) {
        int[]ret = null;
        for(int i=0;i<edges.length;i++){
            int p = edges[i][0];
            int c = edges[i][1];
            if(isSame(p,c)){
                ret = new int[]{p,c};
            }else {
                union(p,c);
            }
        }
        return ret;
    }

    public void union(int i,int j){
        int ii = getFather(i);
        int jj = getFather(j);
        map.put(ii,jj);
    }

    public int getFather(int i){
        if(!map.containsKey(i)){
            map.put(i,i);
            return i;
        }else{
            if(map.get(i)!=i){
                map.put(i,getFather(map.get(i)));
                return map.get(i);
            }else{
                return i;
            }
        }
    }

    public boolean isSame(int i,int j){
        return getFather(i) == getFather(j);
    }
}
