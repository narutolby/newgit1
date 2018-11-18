package context111;

/**
 * @author boyang.lby
 * @date 11/18/18
 * @description
 */
public class FindtheShortestSuperstring {
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        String[][] dp = new String[1<<n][n];
        for(int i = 1;i < 1<<n;i++){
            if(Integer.bitCount(i) == 1){
                dp[i][Integer.numberOfTrailingZeros(i)] = A[Integer.numberOfTrailingZeros(i)];
                continue;
            }
            for(int k = 0;k < n;k++){
                if(i<<~k<0){
                    for(int j = 0;j < n;j++){ // j->k
                        if(i<<~j<0 && j != k){
                            for(int l = A[k].length();l >= 0;l--){
                                if(dp[i^1<<k][j].endsWith(A[k].substring(0, l))){
                                    String can = dp[i^1<<k][j] + A[k].substring(l);
                                    if(dp[i][k] == null || dp[i][k].length() > can.length()){
                                        dp[i][k] = can;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        String ret = dp[(1<<n)-1][0];
        for(int i = 1;i < n;i++){
            if(dp[(1<<n)-1][i].length() < ret.length()){
                ret = dp[(1<<n)-1][i];
            }
        }

        return ret;
    }

}
