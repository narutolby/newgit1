package contest63;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import common.DJSet;

/**
 * @author boyang.lby
 * @date 12/17/17
 * @description
 */
public class ContainVirus1 {
    public int containVirus(int[][] grid) {
        int rs = grid.length;
        int cs = grid[0].length;
        int[]xx = {0,0,1,-1};
        int[]yy = {1,-1,0,0};
        int ret = 0;
        while(true) {
            DJSet djSet = new DJSet(rs * cs);
            for (int i = 0; i < rs; i++) {
                for (int j = 0; j < cs; j++) {
                    if (grid[i][j] != 1) {
                        continue;
                    }
                    for (int d = 0; d < 4; d++) {
                        int nrs = i + xx[d];
                        int ncs = j + yy[d];
                        if (nrs >= 0 && nrs < rs && ncs >= 0 && ncs < cs && grid[nrs][ncs] == 1) {
                            djSet.union(toN(i, j, cs), toN(nrs, ncs, cs));
                        }
                    }
                }
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0;i<rs;i++){
                for(int j=0;j<cs;j++){
                    if(grid[i][j] != 1){
                        continue;
                    }
                    for (int d = 0; d < 4; d++) {
                        int nrs = i + xx[d];
                        int ncs = j + yy[d];
                        if (nrs >= 0 && nrs < rs && ncs >= 0 && ncs < cs && grid[nrs][ncs] == 0) {
                            int key = djSet.root(toN(i,j,cs));
                            if(!map.containsKey(key)){
                                map.put(key,new ArrayList<>());
                            }
                            map.get(key).add(toN(nrs,ncs,cs));
                        }
                    }
                }
            }
            if(map.isEmpty()){
                break;
            }
            int best = 0;
            int bestk = 0;
            Map<Integer, Set<Integer>> map1 = new HashMap<>();
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                map1.put(entry.getKey(),new HashSet<>());
                for(Integer it : entry.getValue()){
                    map1.get(entry.getKey()).add(it);
                }
            }
            for(Map.Entry<Integer, Set<Integer>> entry : map1.entrySet()){
                if(entry.getValue().size() > best){
                    best = entry.getValue().size();
                    bestk = entry.getKey();
                }
            }
            map1.remove(bestk);
            ret += map.get(bestk).size();
            map.remove(bestk);
            for(int i=0;i<rs;i++){
                for(int j=0;j<cs;j++){
                    if(grid[i][j] != 1){
                        continue;
                    }
                    if(djSet.root(toN(i,j,cs)) == bestk){
                        grid[i][j] = 2;
                    }
                }
            }
            for(Map.Entry<Integer, Set<Integer>> entry : map1.entrySet()){
                Set<Integer> set = entry.getValue();
                for(Integer it : set){
                    grid[it/cs][it%cs] = 1;
                }
            }
        }
        return ret;
    }

    public int toN(int i,int j,int m){
        return i * m + j;
    }

    public static void main(String[]args){
        new ContainVirus1().containVirus(new int[][]{
            {0,1,0,0,0,0,0,1},
        {0,1,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0}});
    }
}
