/**
 * @author boyang.lby
 * @date 4/19/17
 * @description
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        if(s1.equals("") || s2.equals("")){
            return (s1+s2).equals(s3);
        }
        char[]s1a = s1.toCharArray();
        char[]s2a = s2.toCharArray();
        char[]s3a = s3.toCharArray();
        int len1 = s1a.length;
        int len2 = s2a.length;
        boolean[][]dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i!=0 && s1a[i-1] == s3a[i+j-1]){
                    dp[i][j] = dp[i-1][j];
                }
                if(j != 0 && s2a[j-1] == s3a[i+j-1]){
                    dp[i][j] = dp[i][j]? dp[i][j] :  dp[i][j-1];
                }

            }
        }
        return dp[len1][len2];
    }
}
