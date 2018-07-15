package contest81;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author boyang.lby
 * @date 4/22/18
 * @description
 */
public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        if (S == null || S.length() == 0){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        char[]chars = S.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i] == C){
                list.add(i);
            }
        }
        int[]ret = new int[S.length()];
        for(int i=0;i<chars.length;i++){
            int index = Collections.binarySearch(list,i);
            if(index >=0){
                ret[i] = 0;
            }else{
                index = -index - 1;
                if(index == 0){
                    ret[i] = list.get(0) - i;
                }else if(index == list.size()){
                    ret[i] = i - list.get(list.size()-1);
                }else{
                    ret[i] = Math.min(list.get(index) - i, i - list.get(index - 1));
                }
            }

        }
        return ret;
    }

    public int[] shortestToChar1(String S, char C) {
        int n = S.length();
        int[] a = new int[n];
        Arrays.fill(a, 9999999);
        for(int i = 0;i < n;i++){
            if(S.charAt(i) == C){
                a[i] = 0;
            }
        }
        for(int i = 1;i < n;i++){
            a[i] = Math.min(a[i], a[i-1] + 1);
        }
        for(int i = n-2;i >= 0;i--){
            a[i] = Math.min(a[i], a[i+1] + 1);
        }
        return a;
    }

    public static void main(String[]args){
        //List<Integer> list = new ArrayList<>();
        //list.add(2);
        //list.add(4);
        //list.add(6);
        //list.add(8);
        //System.out.print(Collections.binarySearch(list,2));
        new ShortestDistancetoaCharacter().shortestToChar1("aaba",'b');
    }
}
