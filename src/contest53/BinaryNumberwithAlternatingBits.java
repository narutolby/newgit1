package contest53;

/**
 * @author boyang.lby
 * @date 10/8/17
 * @description
 */
public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        //return n != 0 && ((n ^ 0x5555) % n == 0 || (n ^ 0xaaaa) % n == 0);
        while(n>0){
            if(((n & 1) ^ (n >> 1 & 1)) != 1){
                return false;
            }
            n = n >> 1;
        }
        return true;
    }
    //public boolean hasAlternatingBits1(int n) {
    //    int i = 1;
    //    while(i<n){
    //        i  = i << 1;
    //    }
    //    if((n ^ 0x5555) == i || (n ^ 0xaaaa) == i){
    //        return true;
    //    }
    //    return false;
    //}

}
