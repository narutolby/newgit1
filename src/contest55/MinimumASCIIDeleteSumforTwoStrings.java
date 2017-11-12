package contest55;

/**
 * @author boyang.lby
 * @date 10/22/17
 * @description
 */
public class MinimumASCIIDeleteSumforTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][]dp = new int[len1+1][len2+1];
        dp[1][0] = s1.charAt(0);
        dp[0][1] = s2.charAt(0);
        for(int i=2;i<=len1;i++){
            dp[i][0] = s1.charAt(i-1) + dp[i-1][0];
        }
        for(int i=2;i<=len2;i++){
            dp[0][i] = s2.charAt(i-1) + dp[0][i-1];
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(c1 + dp[i-1][j],c2 + dp[i][j-1]),c1 + c2 + dp[i-1][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
