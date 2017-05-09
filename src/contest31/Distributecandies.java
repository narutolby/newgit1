package contest31;

import java.util.HashSet;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 5/7/17
 * @description
 */
public class Distributecandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<candies.length;i++){
            set.add(candies[i]);
        }
        int half = candies.length / 2;
        if(half >= set.size()){
            return set.size();
        }else{
            return half;
        }

    }
}
