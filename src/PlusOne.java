/**
 * @author boyang.lby
 * @date 8/2/17
 * @description
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int tmp = 1;
        int len = digits.length;
        for(int i = len - 1;i>=0 && tmp != 0 ;i--){
            int val = digits[i] + tmp;
            digits[i] = val % 10;
            tmp = val / 10;
        }
        if(tmp != 0 ){
            int[]ret = new int[1 + len];
            ret[0] = tmp;
            for(int i=1;i<1 + len;i++){
                ret[i] = digits[i-1];
            }
            return ret;
        }
        return digits;
    }
}
