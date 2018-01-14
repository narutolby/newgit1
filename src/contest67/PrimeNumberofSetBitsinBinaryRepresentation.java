package contest67;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumberofSetBitsinBinaryRepresentation {
    static Set<Integer> set = new HashSet<Integer>(){
        {
            add(2);
            add(3);
            add(5);
            add(7);
            add(11);
            add(13);
            add(17);
            add(19);
        }
    };

    public int countPrimeSetBits(int L, int R) {
        int ret = 0;
        for(int i=L;i<=R;i++){
            String bit = Integer.toBinaryString(i);
            int count = 0;
            char[]chars = bit.toCharArray();
            for(int j=0;j<chars.length;j++){
                if(chars[j] == '1'){
                    count++;
                }
            }
            if(set.contains(count)){
                ret++;
            }
        }
        return ret;
    }
}
