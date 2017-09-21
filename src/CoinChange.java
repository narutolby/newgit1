import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        int[]dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=coins.length;j++){
                if(i-coins[j-1]>=0 && dp[i-coins[j-1]] != -1){
                    dp[i] = Math.min(dp[i],dp[i-coins[j-1]] + 1);
                }
            }
        }
        return dp[amount];
    }
}
