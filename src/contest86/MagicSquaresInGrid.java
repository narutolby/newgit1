package contest86;

import java.util.HashSet;
import java.util.Set;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

 Given an N x N grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).



 Example 1:

 Input: [[4,3,8,4],
 [9,5,1,9],
 [2,7,6,2]]
 Output: 1
 Explanation:
 The following subgrid is a 3 x 3 magic square:
 438
 951
 276

 while this one is not:
 384
 519
 762

 In total, there is only one magic square inside the given grid.
 Note:

 1 <= grid.length = grid[0].length <= 10
 0 <= grid[i][j] <= 15

 */

public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int ret = 0;
        int m = grid.length,n = grid[0].length;
        for(int i=0;i<=m-3;i++){
            outter: for(int j=0;j<=n-3;j++){
                int sum = -1;
                Set<Integer> set = new HashSet<>();
                for(int x=i;x<=i+2;x++){
                    int tmp = 0;
                    for(int y=j;y<=j+2;y++){
                        if(grid[x][y]>9 || grid[x][y]<=0 || set.contains(grid[x][y])){
                            continue outter;
                        }
                        set.add(grid[x][y]);
                        tmp+= grid[x][y];
                    }
                    if(sum == -1){
                        sum = tmp;
                    }else{
                        if(sum != tmp){
                            continue outter;
                        }
                    }
                }
                for(int x=j;x<=j+2;x++){
                    int tmp = 0;
                    for(int y=i;y<=i+2;y++){
                        tmp+= grid[y][x];
                    }
                    if(sum == -1){
                        sum = tmp;
                    }else{
                        if(sum != tmp){
                            continue outter;
                        }
                    }
                }
                if(sum != grid[i][j] + grid[i+1][j+1]+grid[i+2][j+2] && sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]){
                    continue outter;
                }
                ret ++;
            }
        }
        return ret;
    }
}
