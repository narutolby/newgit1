package contest29;

/**
 * @author boyang.lby
 * @date 4/23/17
 * @description
 */
public class LongestLineofConsecutiveOneinMatrix {
    int[][]n = null;
    int sum = 0;
    public int longestLine(int[][] M) {
        if(M == null || M.length == 0){
            return 0;
        }
        n = new int[M.length][M[0].length];
        int x = M.length;
        int y = M[0].length;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++) {
                if ((n[i][j] >> 0 & 1) != 1) {
                    horizontal(M, i, j);
                }

                if ((n[i][j] >> 1 & 1) != 1) {
                    vertical(M, i, j);
                }
                if ((n[i][j] >> 2 & 1) != 1) {
                    diagonal(M, i, j);
                }
                if ((n[i][j] >> 3 & 1) != 1) {
                    antdiagonal(M, i, j);
                }
            }
        }
        return sum;

    }


    void horizontal(int[][]m,int x,int y){
        int ret = 0;
        int len = m[0].length;
        for(int i=y;i<len;i++){
            if(m[x][i] == 1){
                n[x][i] = n[x][i] | (1 << 0);
                ret++;
            }else{
                break;
            }
        }
        sum = Math.max(sum,ret);
    }

    void vertical(int[][]m,int x,int y){
        int ret = 0;
        int len = m.length;
        for(int i=x;i<len;i++){
            if(m[i][y] == 1){
                n[i][y] = n[i][y] | (1 << 1);
                ret++;
            }else{
                break;
            }
        }
        sum = Math.max(sum,ret);
    }

    void diagonal(int[][]m,int x,int y){
        int ret = 0;
        int len = m.length;
        int len1 = m[0].length;
        for(int i=x,j=y;i<len && j<len1;i++,j++){
            if(m[i][j] == 1){
                n[i][j] = n[i][j] | (1 << 2);
                ret++;
            }else{
                break;
            }
        }
        sum = Math.max(sum,ret);
    }
    void antdiagonal(int[][]m,int x,int y){
        int ret = 0;
        int len = m.length;
        for(int i=x,j=y;i<len && j>=0;i++,j--){
            if(m[i][j] == 1){
                n[i][j] = n[i][j] | (1 << 3);
                ret++;
            }else{
                break;
            }
        }
        sum = Math.max(sum,ret);
    }
}
