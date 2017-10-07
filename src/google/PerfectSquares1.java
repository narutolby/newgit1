package google;

import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 10/4/17
 * @description
 */
public class PerfectSquares1 {
    public int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        int[]dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int j;
        for(int i=1;i<=n;i++){
            for(int m=1;(j= (int)Math.pow(m,2))<=i;m++){
                dp[i] = Math.min(dp[i-j]+1,dp[i]);
            }
        }
        return dp[n];
    }
    public static void main(String[]args){
        System.out.println(new PerfectSquares1().numSquares(11));
       // System.out.println(new PerfectSquares().isSquare(11));
    }
}
