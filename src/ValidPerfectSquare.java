/**
 * @author boyang.lby
 * @date 10/27/18
 * @description
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
       long l = 1,r = num;
       while(l <= r) {
           long mid = l + (r - l)/2;
           if(mid * mid == num){
               return true;
           }else if(mid * mid < num){
               l = mid+1;
           }else{
               r = mid -1;
           }
       }
        return false;
    }

}