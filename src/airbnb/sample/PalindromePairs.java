package airbnb.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 9/11/17
 * @description
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0){
            return retList;
        }
        //Set<Integer> set = new HashSet<Integer>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }
        for(int i=0;i<words.length;i++){
            String word = words[i];
            for(int j=0;j<=word.length();j++){
                String str1 = word.substring(0,j);
                String str2 = word.substring(j);
                int index = getMakePalindromeIndex(str1,str2,map,i) ;
                if(index != -1){
                    // if(set.contains(index * words.length + i)){
                    //     continue;
                    // }else{
                    //     set.add(index * words.length + i);
                    // }
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(index);
                    list.add(i);
                    retList.add(list);
                }
                if(str2.equals("")){
                    continue;
                }
                index = getMakePalindromeIndex(str2,str1,map,i) ;
                if(index != -1){
                    // if(set.contains(i * words.length + index)){
                    //     continue;
                    // }else{
                    //     set.add(i * words.length + index);
                    // }
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(index);
                    retList.add(list);
                }
            }
        }
        return retList;
    }

    public int getMakePalindromeIndex(String str1,String str2,Map<String,Integer> map,int index){
        if(isPalindrome(str1)){
            String rev = new StringBuilder(str2).reverse().toString();
            if(map.containsKey(rev) && map.get(rev) != index){
                return map.get(rev);
            }
        }
        return -1;
    }

    public boolean isPalindrome(String word){
        if(word == null) return false;
        int l = 0,r = word.length() - 1;
        while(l<r){
            if(word.charAt(l) != word.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
