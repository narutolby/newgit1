/**
 * @author boyang.lby
 * @date 11/4/17
 * @description
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[]dp = new int[s.length()];
        dp[0] = 1;
        char[]chars = s.toCharArray();
        for(int i=1;i<s.length();i++){
            dp[i] = dp[i-1]+1;
            for(int j=i-1;j>=0;j--){
                if(chars[i] == chars[j]){
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[s.length()-1];
    }
}
