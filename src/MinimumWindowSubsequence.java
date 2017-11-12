import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 11/12/17
 * @description
 */
public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        int lent = T.length();
        int lens = S.length();
        int[][]dp = new int[lent + 1][lens+1];
        for(int i =1;i<=lent;i++){
            Arrays.fill(dp[i],lens + 2);
        }
        int min = lens + 2;
        String ret = "";
        for(int i=1;i<=lent;i++){
            for(int j=1;j<=lens;j++){
                if(S.charAt(j - 1) == T.charAt(i - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(i == lent && dp[i][j] < min){
                        min = dp[i][j];
                        ret = S.substring(j - min ,j);
                    }
                }else{
                    dp[i][j] = dp[i][j-1] + 1;
                }
            }
        }
       return ret;
    }
    public String minWindow1(String S, String T) {
        int len = S.length();
        int[][]next = new int[len+1][26];
        Arrays.fill(next[len],-1);
        for(int j=len-1;j>=0;j--){
            for(int i=25;i>=0;i--){
                next[j][i] = next[j+1][i];
            }
            next[j][S.charAt(j)-'a'] = j;
        }
        int i=0;
        int min = len + 1;
        String ret = "";
        while(i < len){
            int p = next[i][T.charAt(0) - 'a'];
            if(p == -1) return ret;
            int s = p;
            for(int j=1;j<T.length();j++){
                p = next[p][T.charAt(j) - 'a'];
                if(p == -1){
                    return ret;
                }
                p++;
            }
            if(min > p - s ){
                min = p - s ;
                ret = S.substring(s,p);
            }
            i = s + 1;
        }
        return ret;

    }
    public static void main(String[]args){
        new MinimumWindowSubsequence().minWindow1("jmeqksfrsdcmsiwvaovztaqenprpvnbstl" ,"k");
    }
}
