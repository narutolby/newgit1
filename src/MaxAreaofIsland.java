import java.util.Arrays;

public class MaxAreaofIsland {
    class DJSet{
        int[] upper = null;
        int max = 0;
        public DJSet(int n){
            upper = new int[n];
        }
        public int root(int x){
            return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
        }
        public boolean union(int x, int y){
            int rx = root(x),ry = root(y);
            if (rx == ry){ return true; }
            if(upper[rx] < upper[ry]){
                int d = ry; ry = rx; rx = d; }
            upper[ry]+= upper[rx];
            upper[rx] = ry;
            max = Math.max(max,Math.abs(upper[ry]));
            return true;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int x = grid.length,y = grid[0].length;
        DJSet djSet = new DJSet(x * y);
        int[] xx = {0,0,1,-1}, yy = {1,-1,0,0};
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(grid[i][j] == 1){
                    djSet.upper[i*y+j] = djSet.upper[i*y+j] == 0 ? -1:djSet.upper[i*y+j];
                    for(int n =0;n<4;n++){
                        int ni = i + xx[n];
                        int nj = j + yy[n];
                        if(ni >=0 && ni < x && nj >=0 && nj < y && grid[ni][nj] == 1){
                            djSet.upper[ni * y + nj] = djSet.upper[ni * y + nj] == 0 ? -1:djSet.upper[ni * y + nj];
                            djSet.union(i*y + j,ni * y + nj);
                        }
                    }
                }
            }
        }
        return djSet.max;
    }

    public static void main(String[]args){
        new MaxAreaofIsland().maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});
    }

}
