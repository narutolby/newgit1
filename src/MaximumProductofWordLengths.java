import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*************************************************************************
	 File Name: MaximumProductofWordLengths.java
	 Author: boyang.lby
	 Mail: willianlby@aliyun.com
	 Created Time: Tue Aug 22 10:17:52 2017

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

 ************************************************************************/

public class MaximumProductofWordLengths{
    
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0)      {
            return 0;
        }
        int ret = 0;
        int[]code = new int[words.length];
        for(int i=0;i<words.length;i++){
            char[]chars = words[i].toCharArray();
            for(int j=0;j<chars.length;j++){
                code[i] |= 1 << chars[j] - 'a';
            }
        }
        for(int i = 0 ;i<words.length;i++){
            for(int j = 1;j<words.length;j++){
                if((code[i] & code[j]) == 0){
                    ret = Math.max(ret,words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }
}

