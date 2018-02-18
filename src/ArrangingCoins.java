/**
 * @author boyang.lby
 * @date 2/16/18
 * @description
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        long l = 1 , h = n;
        while(l < h){
            long mid = l+ (h - l) / 2;
            if(check(mid,n)){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        return (int)(h-1);
    }

    public boolean check(long i, long n){
        return (1 + i) * i  <= (long)(2 * n);
    }
    public static void main(String[]args){
        System.out.println(new ArrangingCoins().arrangeCoins(1804289383));
    }
}
