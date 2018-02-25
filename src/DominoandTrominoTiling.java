public class DominoandTrominoTiling {
    public int numTilings(int N) {
        if(N == 1){
            return 1;
        }else if(N == 2){
            return 2;
        }
        int mod = 1000000007;
        long[] dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        long sum = dp[0];
        for(int i=3;i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-2] + 2 * sum) % mod;
            sum += dp[i-2];
        }
        return (int)dp[N];
    }
}
