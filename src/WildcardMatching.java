/**
 * @author boyang.lby
 * @date 9/21/17
 * @description
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        if(s.equals(p)){
            return true;
        }
        int len1 = s.length();
        int len2 = p.length();
        boolean[][]dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i=1;i<=len2;i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                char c1 = s.charAt(i-1);
                char c2 = p.charAt(j-1);
                if(c1 == c2 || c2 == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(c2 == '*'){
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
