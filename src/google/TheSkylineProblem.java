package google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 10/14/17
 * @description
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> retList = new ArrayList<>();
        if(buildings == null || buildings.length == 0){
            return retList;
        }
        TreeMap<Integer,List<Integer>> treeMap = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.add(0);
        for(int i =0;i<buildings.length;i++){
            for(int j=0;j<2;j++){
                List<Integer> heightList = null;
                heightList = treeMap.getOrDefault(buildings[i][j],new ArrayList<Integer>());
                heightList.add((j==0?1:-1) * buildings[i][2]);
                treeMap.put(buildings[i][j],heightList);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry : treeMap.entrySet()){
            int maxHeight = pq.peek();
            int position = entry.getKey();
            List<Integer> heightList = entry.getValue();
            for(int height : heightList){
                if(height > 0){
                    pq.add(height);
                }else{
                    pq.remove(-height);
                }
            }
            if(maxHeight != pq.peek()){
                retList.add(new int[]{position,pq.peek()});
            }
        }
        return retList;
    }
    public static void main(String[]args){
        new TheSkylineProblem().getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});
    }
}
