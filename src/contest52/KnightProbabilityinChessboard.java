package contest52;

/**
 * @author boyang.lby
 * @date 10/1/17
 * @description
 */
public class KnightProbabilityinChessboard {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][]dp = new double[N][N][K+1];
        dp[r][c][0]  = 1D;
        int[] xx = {2,2,-2,-2,1,-1,1,-1};
        int[] yy = {1,-1,1,-1,2,2,-2,-2};
        for(int i=1;i<=K;i++){
            for(int m=0;m<N;m++){
                for(int n=0;n<N;n++){
                    if(dp[m][n][i-1] == 0){
                        continue;
                    }
                    for(int cnt=0;cnt<8;cnt++){
                        int xxx = m + xx[cnt];
                        int yyy = n + yy[cnt];
                        if(xxx>=0 && xxx<N && yyy>=0 && yyy<N){
                            dp[xxx][yyy][i] += dp[m][n][i-1] / 8;
                        }
                    }
                }
            }
        }
        double ret = 0D;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ret += dp[i][j][K];
            }
        }
        return ret;
    }

    public static void main(String[]args){
        System.out.println(new KnightProbabilityinChessboard().knightProbability(3,2,0,0));
    }
}
