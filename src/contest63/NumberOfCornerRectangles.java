package contest63;

/**
 * @author boyang.lby
 * @date 12/17/17
 * @description
 */
public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        if(rows == 1 || columns == 1){
            return 0;
        }
        int ret = 0;
        for(int i=2;i<=rows;i++){
            for(int x=0;x+i-1<rows;x++){
                int sum = 0;
                for(int j=0;j<columns;j++){
                    if(grid[x][j] == 1 && grid[x+i-1][j] == 1){
                        sum++;
                    }
                }
                if(sum != 0 && sum != 1){
                    ret += sum * (sum - 1) / 2;
                }
            }
        }
        return ret;
    }

    public static void main(String[]args){
        System.out.println(new NumberOfCornerRectangles().countCornerRectangles(new int[][]{
            {1, 1, 1},
        }));
    }
}
