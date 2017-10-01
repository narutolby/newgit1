package contest52;

/**
 * @author boyang.lby
 * @date 10/1/17
 * @description
 */
public class MaximumSumof3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][][]dp = new int[4][nums.length+1][2];
        int[]num1 = new int[nums.length+1];
        num1[0] = 0;
        for(int i=1;i<=nums.length;i++){
            num1[i] = num1[i-1] + nums[i-1];
        }
        int ret = 0;
        int last = 0;
        for(int i = 1;i<=3;i++){
            for(int j=k*i;j<num1.length;j++){
                if(num1[j] - num1[j-k] + dp[i-1][j-k][0] > dp[i][j-1][0]){
                    dp[i][j][0] = num1[j] - num1[j-k] + dp[i-1][j-k][0];
                    dp[i][j][1] = j - k;
                }else{
                    dp[i][j][0] = dp[i][j-1][0];
                    dp[i][j][1] = dp[i][j-1][1];
                }
                if(dp[3][j][0]>ret){
                    ret = dp[i][j][0];
                    last = j;
                }
            }
        }
        int[]r = new int[3];
        r[2] = last - k;
        r[1] = dp[2][r[2]][1];
        r[0] = dp[1][r[1]][1] ;
        return r;
    }
    public static void main(String[]args){
        new MaximumSumof3NonOverlappingSubarrays().maxSumOfThreeSubarrays(new int[]{7,13,20,19,19,2,10,1,1,19},3);
    }
}
