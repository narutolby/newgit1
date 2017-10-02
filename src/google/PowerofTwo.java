package google;

/**
 * @author boyang.lby
 * @date 10/2/17
 * @description
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n - 1)) == 0 ;
    }
}
