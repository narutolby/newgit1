package airbnbgo;

/**
 * @author boyang.lby
 * @date 2/10/19
 * @description
 * 分三种情况:
 * 1,字母 dp[i][j] = dp[i-1][j-1]
 * 2,.  dp[i][j] = dp[i-1][j-1]
 * 3,* 0次或多次,
 *    - dp[i][j] = dp[i][j-2] if s[i-1] != p[j-1] and p[j-1] != '.'
 *    - dp[i][j] = dp[i][j-2] or dp[i][j-1] or dp[i-1][j]
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        if(s.equals(p)){
            return true;
        }

        boolean[][]dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if (sc == pc || pc == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pc == '*'){
                    if (sc != p.charAt(j-2) && p.charAt(j-2) != '.'){
                        dp[i][j] = dp[i][j-2];
                    }else{
                        dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
