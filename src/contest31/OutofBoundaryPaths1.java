package contest31;

/**
 * @author boyang.lby
 * @date 5/7/17
 * @description
 */
public class OutofBoundaryPaths1 {

    int[][]step = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    int mod = 1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][]dp = new int[60][60][60];
        dp[i][j][0] = 1;
        int aws = 0;
        for(int nn=1;nn<=N;nn++){
            for(int ii=0;ii<m;ii++){
                for(int jj=0;jj<n;jj++){
                    if(dp[ii][jj][nn-1] != 0){
                        for(int s=0;s<4;s++){
                            int xx = ii + step[s][0];
                            int yy = jj + step[s][1];
                            if(xx >=0 && xx<m && yy >= 0 && yy < n){
                                dp[xx][yy][nn] = (dp[xx][yy][nn] + dp[ii][jj][nn-1])%mod ;
                            }else{
                                aws += dp[ii][jj][nn-1];
                                aws = aws % mod;
                            }
                        }
                    }
                }
            }
        }
        return aws;
    }

}
