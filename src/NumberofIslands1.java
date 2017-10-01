import java.util.LinkedList;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 9/26/17
 * @description
 */
public class NumberofIslands1 {
    public int numIslands(char[][] grid) {
        int ret = 0;
        if(grid.length == 0 || grid[0].length == 0){
            return ret;
        }
        int len1 = grid.length;
        int len2 = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int[]xx = new int[]{0,0,1,-1};
        int[]yy = new int[]{1,-1,0,0};
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(grid[i][j] == 1){
                    ret++;
                    queue.add(i*len2 + j);
                    while(!queue.isEmpty()){
                        int p = queue.poll();
                        int x = p / len2;
                        int y = p % len2;
                        grid[x][y] = 0;
                        for(int n=0;n<4;n++){
                            int tx = x + xx[n];
                            int ty = y + yy[n];
                            if(tx>=0 && tx<len1 && ty>=0 && ty<=len2 && grid[tx][ty] != 0){
                                queue.add(tx * len2 + ty);
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}
