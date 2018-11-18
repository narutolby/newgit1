package context111;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author boyang.lby
 * @date 11/18/18
 * @description
 */
public class DIStringMatch {
    public int[] diStringMatch(String S) {
        Integer[]array = new Integer[S.length() + 1];
        Integer[]array1 = new Integer[S.length() + 1];
        array[0] = 0;
        array1[0] = 0;
        char[]chars = S.toCharArray();
        for(int i=0;i<chars.length;i++){
            array1[i+1] = i+1;
            char c = chars[i];
            if(c == 'I'){
                array[i+1] = array[i]+1;
            }else{
                array[i+1] = array[i]-1;
            }
        }
        Arrays.sort(array1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return array[o1] - array[o2];
            }
        });
        int[]ret = new int[S.length()+1];
        for(int i=0;i<S.length()+1;i++){
            ret[array1[i]] = i;
        }

        return ret;
    }

    public static void main(String[]args){
        new DIStringMatch().diStringMatch("IDID")     ;
    }
}
