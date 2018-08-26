package contest99;

/**
 * @author boyang.lby
 * @date 8/26/18
 * @description
 */
public class J892 {
    public int surfaceArea(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int ret = 0;
        int m = grid.length,n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int v = grid[i][j];
                if(v == 0){
                    continue;
                }
                ret += 4 * v + 2;
                if(i-1>=0 && grid[i-1][j] != 0){
                    ret -= Math.min(grid[i-1][j],grid[i][j]) * 2;
                }
                if(j-1>=0 && grid[i][j-1] != 0){
                    ret -= Math.min(grid[i][j-1],grid[i][j]) * 2;
                }
            }
        }
        return ret;
    }
    public static void main(String[]args){
        System.out.print(new J892().surfaceArea(new int[][]{{1,0},{0,2}}));
    }
}
