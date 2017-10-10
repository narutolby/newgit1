package contest53;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 10/8/17
 * @description
 */
public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int ret = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return ret;
        }
        int m = grid.length,n = grid[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] xx = {1,-1,0,0};
        int[] yy = {0,0,1,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    continue;
                }
                int tmp = 1;
                grid[i][j] = 0;
                queue.add(i * n + j);
                while(!queue.isEmpty()){
                    int q = queue.poll();
                    int x = q / n;
                    int y = q % n;
                    for(int t = 0;t<4;t++)        {
                        int xxx = x + xx[t];
                        int yyy = y + yy[t];
                        if(xxx>=0 && xxx<m && yyy >=0 && yyy <n && grid[xxx][yyy] == 1){
                            queue.add(xxx * n + yyy);
                            tmp++;
                            grid[xxx][yyy] = 0;
                        }
                    }
                }
                ret = Math.max(ret,tmp);
            }
        }
        return ret;
    }
}
