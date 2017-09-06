import java.util.HashSet;
import java.util.Set;

public class BulbSwitcherII {
    public int flipLights(int n, int m) {
        n = Math.min(6,n);
        int mask = (1 << n) - 1;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i < 16; i++){
            int x = 0;
            int mm = Integer.bitCount(i);
            if(mm % 2 == m % 2 && mm <= m){
                if((i & 1) != 0) {
                    x = mask ^ mask;
                }
                if((i & 2) != 0){
                    x = x ^ (0x2a & mask);
                }
                if( (i & 4) != 0){
                    x = x ^ (0x15 & mask);
                }
                if( (i & 8) != 0){
                    x = x ^ (0x24 & mask);
                }
                set.add(x);
            }
        }
        return set.size();
    }

    public static void main(String[]args){
        new BulbSwitcherII().flipLights(2,1);
    }
}
