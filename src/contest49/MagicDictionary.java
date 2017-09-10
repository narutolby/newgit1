package contest49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicDictionary {
    /** Initialize your data structure here. */

    Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();

    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
       if(dict == null || dict.length == 0) {
           return;
       }
       for(String word : dict){
           List<String> list = null;
           if(map.containsKey(word.length())){
               list = map.get(word.length());
           }else{
               list = new ArrayList<String>();
               map.put(word.length(),list);
           }
           list.add(word);
       }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        if(map.size() == 0 || !map.containsKey(word.length())){
            return false;
        }
        List<String> list = map.get(word.length());
        char[]wordArray = word.toCharArray();
        for(String w : list){
            char[]wa = w.toCharArray();
            int i = 0;
            for(;i<word.length() && wa[i] == wordArray[i];i++){
            }
            if(i == word.length()){
                continue;
            }else{
               if(w.substring(i+1).equals(word.substring(i+1))) {
                   return true;
               }
            }
        }
        return false;
    }

    public static void main(String[]args){
        MagicDictionary obj = new MagicDictionary();
        String[]dict = new String[]{"hello","leetcode"};
        obj.buildDict(dict);
        System.out.println(obj.search("hello"));
        System.out.println(obj.search("hhllo"));
        System.out.println(obj.search("hell"));
        System.out.println(obj.search("leetcoded"));
    }
}
