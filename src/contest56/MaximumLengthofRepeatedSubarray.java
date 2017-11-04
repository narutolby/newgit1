package contest56;

/**
 * @author boyang.lby
 * @date 10/29/17
 * @description
 */
public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int lena = A.length;
        int lenb = B.length;
        int[][]dp = new int[lena+1][lenb+1];
        int ret = 0;
        for(int i=1;i<=lena;i++){
            for(int j=1;j<=lenb;j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                ret = Math.max(ret,dp[i][j]);
            }
        }
        return ret;
    }
}
