/**
 * @author boyang.lby
 * @date 1/20/18
 * @description
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        int n = matrix[0].length;
        for(int i=0;i< (n + 1)/2;i++){
            for(int j=i;j<n-1-i;j++){
                int x = i,y = j;
                for(int m=0;m<4;m++){
                    int nx = y;
                    int ny = n - 1 - x;
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[nx][ny];
                    matrix[nx][ny] = tmp;
                    x = nx;
                    y = ny;
                }
            }
        }
    }
}
