package contest93;

import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 7/15/18
 * @description
 */
public class Q871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int ret = 0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int[]ia : stations){
            treeMap.put(ia[0],ia[1]);
        }
        while(startFuel < target){
            if(treeMap.isEmpty()){
                return -1;
            }
            Integer floorKey = treeMap.floorKey(startFuel);
            if(floorKey == null){
                return -1;
            }
            startFuel = startFuel + treeMap.get(floorKey);
            ret++;
            treeMap.remove(floorKey);
        }
        return ret;
    }
    public static void main(String[]args){
        System.out.println(new Q871().minRefuelStops(100,50,new int[][]{{25,50},{50,25}}));
    }
}
