package contest93;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 7/15/18
 * @description
 */
public class Q8711 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target){
            return 0;
        }
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startFuel,0,-1});
        while(!queue.isEmpty()){
            Integer[] item = queue.poll();
            for(int i=item[2]+1;i<stations.length;i++){
                if(item[0]>=stations[i][0]){
                    if(item[0] + stations[i][1]>=target){
                        return item[1]+1;
                    }
                    queue.add(new Integer[]{item[0]+stations[i][1],item[1]+1,i});
                }else{
                    break;
                }
            }
        }
        return -1;
    }
    public static void main(String[]args){
        System.out.println(new Q8711().minRefuelStops(1000, 50, new int[][] {{25, 30}}));
    }
}
