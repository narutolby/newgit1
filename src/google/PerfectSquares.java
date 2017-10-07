package google;

/**
 * @author boyang.lby
 * @date 10/4/17
 * @description
 */
public class PerfectSquares {
    int ret = Integer.MAX_VALUE;
    public int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        numSquares1(n,0);
        return ret;
    }



    public void numSquares1(int n,int s) {
        if(n == 0){
            ret  = Math.min(ret,s);
            return;
        }
        for(int i=1;i<=n;i++){
            if(isSquare(i)){
                numSquares1(n-i,s+1);
            }
        }
    }
    public boolean isSquare(int n){
        if(Math.pow((int)(Math.sqrt(n)),2) == n){
            return true;
        }
        return false;
    }
    public static void main(String[]args){
        System.out.println(new PerfectSquares().numSquares(11));
       // System.out.println(new PerfectSquares().isSquare(11));
    }
}
