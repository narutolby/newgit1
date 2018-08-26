package contest99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 8/26/18
 * @description
 */
public class J893 {
    public int numSpecialEquivGroups(String[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        Set<String> set = new HashSet<>();
        for(String str:A){
            char[] chars = str.toCharArray();
            List<Character> even = new ArrayList<Character>();
            List<Character> odd = new ArrayList<Character>();
            for(int i=0;i<chars.length;i++){
                if(i % 2 == 0){
                    even.add(chars[i]);
                }else{
                    odd.add(chars[i]);
                }
            }
            Collections.sort(even);
            Collections.sort(odd);
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int i=0;i<Math.max(even.size(),odd.size());i++){
                if(i<even.size()){
                    sb1.append(even.get(i));
                }
                if(i < odd.size()){
                    sb2.append(odd.get(i));
                }
            }
            set.add(sb1.toString() + sb2.toString());
        }
        return set.size();
    }
    public static void main(String[]args){
        System.out.println(new J893().numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
    }
}
