/**
 * @author boyang.lby
 * @date 1/6/18
 * @description
 */
public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        while(n>0){
            if(((n & 1) ^ 1) != ((n >> 1) & 1)){
                return false;
            }
            n = n >> 1;
        }
        return true;
    }
}
