package contest48;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 9/3/17
 * @description
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        if(num >=0 && num < 10){
            return num;
        }
        String str = String.valueOf(num);
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[]sa = str.toCharArray();
        List<Character> list = new ArrayList<Character>();
        for(int i=0;i<sa.length;i++){
            map.put(sa[i],i);
            list.add(sa[i]);
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2 - o1;
            }
        });
        for(int i=0;i<list.size();i++){
            if(list.get(i) != sa[i]){
                sa[map.get(list.get(i))] = sa[i];
                sa[i] = list.get(i);
                break;
            }
        }
        String ret = new String(sa);
        return Integer.valueOf(ret);
    }
    public static void main(String[]args){
        System.out.println(new MaximumSwap().maximumSwap(7345));
    }
}
