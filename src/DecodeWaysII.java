/**
 * @author boyang.lby
 * @date 2/16/18
 * @description
 */
public class DecodeWaysII {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int mod = 1000000007;
        int[]dp = new int[s.length()+1];
        char[]chars = s.toCharArray();
        char first = chars[0];
        dp[0] = 1;
        if(first == '*'){
            dp[1] = 9;
        }else{
            dp[1] = 1;
        }
        for(int i=1;i<chars.length;i++) {
            char c = chars[i];
            int count = 1;
            if(c == '*'){
                count = 9;
            }
            dp[i+1] = dp[i]* count % mod;
            char prechar = chars[i-1];
            int precount = 0;
            if(prechar == '1'){
                if(c == '*'){
                    precount = 9;
                }else{
                    precount = 1;
                }
            }else if(prechar == '2'){
                if(c == '*'){
                    precount = 6;
                }else if(c > '6'){
                    precount = 0;
                }else{
                    precount = 1;
                }
            }else if(prechar == '*'){
                if( c== '*'){
                    precount = 26;
                }else if(c > '6'){
                    precount = 1;
                }else{
                    precount = 2;
                }
            }else{
                precount = 0;
            }
            dp[i+1] += (dp[i-1] * precount % mod);
        }
        return dp[s.length()] % mod;
    }
}
