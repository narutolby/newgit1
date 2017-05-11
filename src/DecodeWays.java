/**
 * @author boyang.lby
 * @date 5/11/17
 * @description
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[]dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i=2;i<=s.length();i++){
            if(Integer.valueOf(s.substring(i-2,i))<=26 && Integer.valueOf(s.substring(i-2,i))>0 && s.charAt(i-2) != '0'){
                dp[i] += dp[i-2];
            }
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
