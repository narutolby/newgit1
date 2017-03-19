/**
 * @author boyang.lby
 * @date 3/12/17
 * @description
 */
public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[][]dy = new int[n][n];
        for(int i=0;i<n;i++){
            dy[i][i] = 1;
        }
        for(int i =2;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int start = j,end = j+i-1;
                if(s.charAt(start) == s.charAt(end)){
                    if(start + 1 > end - 1){
                        dy[start][end] = 2;
                    }else{
                        dy[start][end] = dy[start+1][end-1] + 2;
                    }
                }else{
                    dy[start][end] = Math.max(dy[start+1][end],dy[start][end-1]);
                }
            }
        }
        return dy[0][n-1];
    }
}
