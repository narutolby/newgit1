import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 10/7/17
 * @description
 */
public class UniqueSubstringsinWraparoundString {
    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0){
            return 0;
        }
        int[]table = new int[26];
        int[]dp = new int[p.length()];
        Arrays.fill(dp,1);
        table[p.charAt(0) - 'a'] = 1;
        for(int i=1;i<p.length();i++){
            char pre = p.charAt(i-1);
            char cur = p.charAt(i);
            if(cur - pre == 1 || pre == 'z' && cur == 'a'){
                dp[i] = dp[i-1] + dp[i];
            }
            table[cur - 'a'] = Math.max(table[cur - 'a'],dp[i]);
        }
        int ret = 0;
        for(int i=0;i< table.length;i++){
            ret += table[i];
        }
        return ret;
    }
}
