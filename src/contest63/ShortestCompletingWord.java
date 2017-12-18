package contest63;

import java.util.HashMap;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 12/17/17
 * @description
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String ret = "";
        int maxLen = Integer.MAX_VALUE;
        Map<Character,Integer> carry = toCarray(licensePlate);
        for(String word : words){
            Map<Character,Integer> tmp = toCarray(word);
            if( contains(tmp,carry) && maxLen > word.length()){
                maxLen = word.length();
                ret = word;
            }
        }
        return ret;
    }

    public boolean contains(Map<Character,Integer> map1,Map<Character,Integer>map2){
        for(Map.Entry<Character,Integer> entry : map2.entrySet()){
            if(!map1.containsKey(entry.getKey()) || map1.get(entry.getKey())<entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public char toLowerChar(char s){
        if(s >= 'a' && s <= 'z'){
            return s;
        }else if(s>='A' && s<='Z'){
            return (char)(s + 32);
        }
        return '-';
    }

    public Map<Character,Integer> toCarray(String word){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            char s = toLowerChar(c);
            if(s == '-'){
                continue;
            }
            map.put(s,map.getOrDefault(s,0) + 1);
        }
        return map;
    }

    public static void main(String[]args){
        new ShortestCompletingWord().shortestCompletingWord("1s3 PSt",new String[]{"step", "steps", "stripe", "stepple"});
    }
}
