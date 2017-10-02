package google;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p == null || s == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        boolean[][]dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1;i<=p.length();i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=p.length();j++){
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if(sc == pc || pc == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pc == '*'){
                    if(p.charAt(j-2) != sc && p.charAt(j-2) != '.'){
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
