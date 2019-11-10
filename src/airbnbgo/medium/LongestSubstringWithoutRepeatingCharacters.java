package airbnbgo.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 11/10/19
 * @description
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> keyIndex = new HashMap<Character,Integer>();
        int max = 0,start = 0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(keyIndex.containsKey(c) && keyIndex.get(c) >= start){
                max = Math.max(i  - start,max);
                start = keyIndex.get(c) + 1;
            }
            keyIndex.put(c,i);
        }
        max = Math.max(s.length() - start,max);
        return max;
    }

    public static void main(String[]args){
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
    }
}
