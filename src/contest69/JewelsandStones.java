package contest69;

import java.util.HashSet;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 1/28/18
 * @description
 */
public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0 || S == null || S.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for(Character c : J.toCharArray()){
            set.add(c);
        }
        int ret = 0;
        for(Character c : S.toCharArray()){
            if(set.contains(c)){
                ret++;
            }
        }
        return ret;
    }
}
