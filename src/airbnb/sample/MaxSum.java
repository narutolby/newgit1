package airbnb.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 9/11/17
 * @description
 */
public class MaxSum {
    static List<String> list = new ArrayList<>();
    static Map<String,Integer> map = new HashMap<String,Integer>();
    public static void main(String[]args) {
        String[] dict = new String[] {"abc", "cfi", "beh", "defi", "gh"};

        for(String word : dict){
            int i =0;
            char[]chars = word.toCharArray();
            for(char c : chars){
                i = i | 1 << (c-'a');
            }
            map.put(word,i);
        }
        ddd(dict,new HashSet<String>(),new ArrayList<String>());
        System.out.println(Arrays.asList(list));
    }

    public static void ddd(String[]dict,Set<String> set,List<String>words){
       for(int i=0;i<dict.length;i++) {
           if(set.contains(dict[i])){
               continue;
           }
           boolean d = true;
           for(String word :words){
               if(((int)map.get(word) & (int)map.get(dict[i])) != 0){
                   d = false;
                   break;
               }
           }
           if(d){
               words.add(dict[i]);
               if(words.size() > list.size()){
                   list.clear();
                   list.addAll(words);
               }
           }
           set.add(dict[i]);
           ddd(dict, set, words);
           set.remove(dict[i]);
       }
    }
}
