/**
 * @author boyang.lby
 * @date 10/7/17
 * @description
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[][]dp = new int[len+1][len+1];
        for(int i=len-1;i>=0;i--){
            dp[i][len] = dp[i+1][len];
            for(int j=len-1;j>=i;j--){
                if(i == j || (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1] == 1))){
                    dp[i][len]++;
                    dp[i][j] = 1;
                }
            }
        }
        return dp[0][len];
    }
    public static void main(String[]args){
        new PalindromicSubstrings().countSubstrings("aaaaa");
    }
}
