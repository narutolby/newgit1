package contest73;

/**
 * @author boyang.lby
 * @date 2/25/18
 * @description
 */
public class DominoandTrominoTiling {
    public int numTilings(int N) {
        int[]dp = new int[N+1];
        if ( N == 1){
            return 1;
        }else if (N == 2){
            return 2;
        }else if (N == 3){
            return 5;
        }
        int mod = 1000000007;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i=4;i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3] * 4) % mod;
        }
        return dp[N] % mod;
    }
}
