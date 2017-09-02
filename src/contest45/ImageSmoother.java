package contest45;

/**
 * @author boyang.lby
 * @date 8/20/17
 * @description
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if(M == null) {
            return null;
        }
        int m = M.length,n = M[0].length;
        int[] x = {-1,0,1};
        int[] y = {-1,0,1};
        int[][]ret = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum = 0;
                int cells = 0;
                for(int s = 0; s<3;s++){
                    for(int t = 0; t<3;t++){
                        if(i+x[s]>=0 && i+x[s]<m && j+y[t]>=0 && j+y[t]<n){
                            cells ++;
                            sum += M[i+x[s]][j+y[t]];
                        }
                    }
                }
                ret[i][j] = sum/cells;
            }
        }
        return ret;
    }
}
