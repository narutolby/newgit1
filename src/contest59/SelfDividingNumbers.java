package contest59;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 11/19/17
 * @description
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> retList = new ArrayList<>();
        if(left >= right){
            return retList;
        }
        for(int i=left;i<=right;i++){
            if(check(i)) {
                retList.add(i);
            }
        }
        return retList;
    }

    boolean check(int i){
        if(i == 0 || i % 10 == 0){
            return false;
        }
        int tmp = i;
        while(tmp!=0){
            int n = tmp % 10;
            if(n == 0){
                return false;
            }
            if(i % n != 0){
                return false;
            }
            tmp = tmp / 10;
        }
        return true;
    }
    public static void main(String[]args){
        new SelfDividingNumbers().selfDividingNumbers(1,22);
    }
}
