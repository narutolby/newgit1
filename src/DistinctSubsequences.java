/**
 * @author boyang.lby
 * @date 4/8/17
 * @description
 */

/**
 * exhaustion method
 */
public class DistinctSubsequences {
    int ret = 0;
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return 0;
        }
        exhaustion(s,t,0,0);
        return ret;
    }

    public void exhaustion(String s,String t,int i,int j){

        int len = s.length() - (t.length() - j -1);
        for(int m=i;m<len;m++){
            if(s.charAt(m) == t.charAt(j)){
                if(j == t.length()-1){
                    ret++;
                }else{
                    exhaustion(s,t,m+1,j+1);
                }
            }
        }
    }

    /**
     * dp
     * @param s
     * @param t
     * @return
     */
    public int numDistinct1(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return 0;
        }
        int sl = s.length();
        int tl = t.length();
        int[][]dy = new int[tl+1][sl+1];
        for(int i=1;i<=tl;i++){
            for(int j=1;j<=sl;j++){
                dy[0][j-1] = 1;
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dy[i][j] = dy[i-1][j-1] + dy[i][j-1];
                }else{
                    dy[i][j] = dy[i][j-1];
                }
            }
        }
        return dy[tl][sl];
    }

    public static void main(String[]args){
        new DistinctSubsequences().numDistinct1("b","b");
    }
}
