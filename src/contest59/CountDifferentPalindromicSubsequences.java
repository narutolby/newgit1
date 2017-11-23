package contest59;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 11/19/17
 * @description
 */
public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        char[]sa = S.toCharArray();
        int mod = 1000000007;
        int[][] next1 = new int[len][4];
        int[][] next2 = new int[len][4];
        for(int i=len-1;i>=0;i--){
            for(int j=0;j<4;j++){
                if(i==len-1){
                    next1[i][j] = -1;
                }else{
                    next1[i][j] = next1[i+1][j];
                }
            }
            next1[i][sa[i]-'a'] = i;
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<4;j++){
                if(i==0){
                    next2[i][j] = -1;
                }else{
                    next2[i][j] = next2[i-1][j];
                }
            }
            next2[i][sa[i]-'a'] = i;
        }
        int[][]dp = new int[len][len];
        for(int n = 1;n<=len;n++){
            for(int i=0;i+n-1<len;i++){
                int j = i + n - 1;
                if(sa[i] != sa[j]){
                    continue;
                }
                for(int m=0;m<4;m++){
                    int nx = next1[i+1][m];
                    int ny = next2[j-1][m];
                    if(nx < ny){
                        dp[i][j] += dp[nx][ny];
                    }
                    if(nx > ny){
                        dp[i][j] += 1;
                    }
                    dp[i][j] = dp[i][j] % mod;
                }
            }
        }
        return 0;

    }

}
