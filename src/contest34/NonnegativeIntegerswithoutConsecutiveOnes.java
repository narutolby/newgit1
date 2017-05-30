package contest34;

/**
 * @author boyang.lby
 * @date 5/28/17
 * @description
 */
public class NonnegativeIntegerswithoutConsecutiveOnes {
    public int findIntegers(int num) {
        Integer a ;
        int ret = 0;
        for(int i=0;i<=num;i++){
            int j = 0;
            boolean m = false;
            for(j=0;j<31;j++){
                if((i>>j) % 2 ==1 && (i>>j+1) % 2 == 1){
                    m = true;
                    break;
                }
            }
            if(!m){
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[]ars){
        new NonnegativeIntegerswithoutConsecutiveOnes().findIntegers(3);
    }
}
