import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 3/19/17
 * @description
 */
public class PalindromePartitioningII {
    /**
     * Takes a long time;
     * @param str
     * @return
     */
    public int minCut(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return 0;
        }
        int length = str.length();
        int[][] dy = new int[length][length];
        for (int i = 0; i < length; i++) {
            dy[i][i] = 0;
        }
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j <= length - i; j++) {
                int s = j;
                int e = j + i - 1;
                if (str.charAt(s) == str.charAt(e) && (s + 1 > e - 1 || dy[s+1][e-1] == 0)) {
                    dy[s][e]=0;
                }else{
                    dy[s][e] = Integer.MAX_VALUE;
                    for(int x = s;x<e;x++){
                        dy[s][e] = Math.min(dy[s][e],dy[s][x] + dy[x+1][e] + 1);
                    }
                }

            }
        }
        return dy[0][length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII()._minCut("cabababcbc"));
    }



    public int _minCut(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return 0;
        }
        int length = str.length();
        int[][]dy = new int[length][length];
        for(int i=0;i<length;i++){
            dy[i][i] = 0;
        }
        for(int j=length-1;j>=0;j--){
            dy[j][length-1] = length - j -1;
            for(int i=j;i<length;i++){
                if(str.charAt(j) == str.charAt(i) && (i - j < 2 || dy[j+1][i-1] == 1)){
                    dy[j][i] = 1;
                    if(i == length - 1){
                        dy[j][length - 1] = 0;
                    }else{
                        dy[j][length-1] = Math.min(dy[j][length-1],dy[i+1][length-1] + 1);
                    }
                }
            }
        }
        return dy[0][length-1];
    }
}
