import java.util.HashMap;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 9/2/17
 * @description
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return "";
        }
        int count = 0;
        Map<Character,Integer> tmap = new HashMap<Character,Integer>();
        Map<Character,Integer> smap = new HashMap<Character,Integer>();
        char[] ta = t.toCharArray();
        for(char c : ta){
            tmap.put(c,tmap.getOrDefault(c,0) + 1);
        }
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        String ret = "";
        for(int i=0;i<s.length();i++){
            char sc = s.charAt(i);
            if(tmap.containsKey(sc)){
                smap.put(sc,smap.getOrDefault(sc,0)+1);
                if(smap.get(sc) <= tmap.get(sc)){
                    count++;
                }
            }else {
                continue;
            }
            if(count == t.length()){
                while(start<=i){
                    char stc = s.charAt(start);
                    if(!tmap.containsKey(stc) || smap.get(stc)>tmap.get(stc)){
                        start++;
                        if(smap.containsKey(stc)){
                            smap.put(stc,smap.get(stc) - 1);
                        }
                    }else{
                        int len = i - start;
                        if(minLen > len){
                            ret = s.substring(start,i+1);
                            minLen = len;
                        }
                        break;
                    }
                }
            }
        }
        return ret;
    }
    public static void main(String[]args){
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC","ABC"));
    }
}
