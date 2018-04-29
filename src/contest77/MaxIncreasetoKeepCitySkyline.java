package contest77;

import java.io.IOException;

public class MaxIncreasetoKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[]top = new int[grid[0].length];
        int[]left = new int[grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                left[i] = Math.max(left[i],grid[i][j]);
                top[j] = Math.max(top[j],grid[i][j]);
            }
        }
        int ret = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ret += Math.min(left[i],top[j]) - grid[i][j];
            }
        }
        return ret;
    }
}
