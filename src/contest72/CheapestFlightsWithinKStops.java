package contest72;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 2/18/18
 * @description
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][]adj = new int[n][n];
        int[]weight = new int[n];
        for(int i=0;i<flights.length;i++){
            adj[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        int ret = Integer.MAX_VALUE;
        Arrays.fill(weight, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        weight[src] = 0;
        int step = -1;
        int count = 1;
        while(true){
            int tmp = 0;
            for(int i=0;i<count;i++){
                int next = queue.poll();
                int[]adjList = adj[next];
                for(int j=0;j<adjList.length;j++){
                    if(adjList[j] == 0){
                        continue;
                    }
                    if(j == dst){
                        ret = Math.min(ret,weight[next] + adj[next][dst]);
                    }else if(weight[j] > weight[next] + adj[next][j]){
                        weight[j] = weight[next] + adj[next][j];
                        queue.add(j);
                        tmp++;
                    }
                }
            }
            step++;
            count = tmp;
            if(count == 0 || step == K){
                break;
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public int findCheapestPrice1(int n, int[][] es, int src, int dst, int K) {
        long[] ds = new long[n];
        Arrays.fill(ds, Long.MAX_VALUE / 2);
        ds[src] = 0;
        long ans = ds[dst];
        for(int i = 0;i < K+1;i++){
            long[] nds = new long[n];
            Arrays.fill(nds, Long.MAX_VALUE / 2);
            for(int[] e : es){
                nds[e[1]] = Math.min(nds[e[1]], ds[e[0]] + e[2]);
            }
            ds = nds;
            ans = Math.min(ans, ds[dst]);
        }
        return ans < Integer.MAX_VALUE ? (int)ans : -1;
    }
}
