package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() ==0){
            return Collections.EMPTY_LIST;
        }
        String[]dic = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> retList = new ArrayList<String>();
        dfs(digits,0,dic,retList,"");
        return retList;
    }

    public void dfs(String d,int i,String[]dict,List<String> list,String ret){
        if(i == d.length()){
            list.add(ret);
            return;
        }
        int num = d.charAt(i) - '0';
        String str = dict[num];
        for(char c : str.toCharArray()){
            dfs(d,i+1,dict,list,ret+c);
        }
    }
}
