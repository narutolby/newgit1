/**
 * @author boyang.lby
 * @date 5/10/17
 * @description
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String ss) {
        String ret = "";
        if(ss == null || ss.length() == 0){
            return ret;
        }
        ret = ss.substring(0,1);
        int length = 1;
        int len = ss.length();
        boolean[][]dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        for(int i=2;i<=len;i++){
            for(int j=0;j<=len-i;j++){
                int s = j,e = j+i-1;
                if(ss.charAt(s) == ss.charAt(e)){
                    if(s+1>e-1){
                        dp[s][e] = true;
                    }else{
                        dp[s][e] = dp[s+1][e-1];
                    }
                    if(dp[s][e] && e - s + 1 > length){
                        length = e - s + 1;
                        ret = ss.substring(s,e+1);
                    }
                }
            }
        }
        return ret;
    }
}
