import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 5/13/17
 * @description
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int ret = 0;
        if(matrix == null || matrix.length == 0){
            return ret;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[]left = new int[n];
        int[]right = new int[n];
        int[]height = new int[n];
        Arrays.fill(right,n-1);
        Arrays.fill(left,0);
        Arrays.fill(height, 0);
        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int cur = 0;
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1') {left[j] = Math.max(left[j],cur);}
                else {cur = j + 1;left[j] = 0;}
            }
            cur = n-1;
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j] == '1') {right[j] = Math.min(right[j],cur);}
                else {cur = j-1;right[j] = n-1;}
            }
            for(int j=0;j<n;j++){
                ret = Math.max(ret,(right[j] - left[j] + 1) * height[j]);
            }
        }
        return ret;
    }
}
