import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int ret = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c)>=start){
                ret = Math.max(ret,i - start);
                start = map.get(c) + 1;
            }
            map.put(c,i);
        }
        return Math.max(ret,s.length() - start);
    }
    public static void main(String[]args){
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
    }
}
