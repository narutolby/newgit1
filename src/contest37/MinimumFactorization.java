package contest37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author boyang.lby
 * @date 6/18/17
 * @description
 */
public class MinimumFactorization {
    public int smallestFactorization(int a) {
        int max = Integer.MAX_VALUE;
        long ret = 0L;
        List<Integer> list = new ArrayList<Integer>();
        if(a < 10){
            return  a;
        }
        while(a != 1){
            int i = 9;
            for(i=9;i>=1;i--){
                if(a%i == 0){
                    if(i != 1){
                        list.add(i);
                    }
                    a = a / i;
                    break;
                }
            }
            if(i == 1 && a >= 10){
                return 0;
            }
        }
        Collections.sort(list);
        for(Integer i : list){
            ret = ret * 10 + i;
            if(ret > max) return 0;
        }
        return (int)ret;
    }
}
