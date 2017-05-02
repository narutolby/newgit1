package contest30;

/**
 * @author boyang.lby
 * @date 4/30/17
 * @description
 */
public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length == 0){
            return nums;
        }
        int row = nums.length;
        int col = nums[0].length;
        if(row * col != r *c){
            return nums;
        }
        int[][]aws = new int[r][c];
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                count ++;
                int x,y;
                if(count % c == 0){
                    x = count/c - 1;
                    y = c-1;
                }else{
                    x = count/c;
                    y = count % c - 1;
                }
                aws[x][y] = nums[i][j];
            }
        }
        return aws;
    }
}
