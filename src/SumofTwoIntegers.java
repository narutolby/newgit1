/**
 * @author boyang.lby
 * @date 8/15/17
 * @description
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b)<<1);
    }
}
