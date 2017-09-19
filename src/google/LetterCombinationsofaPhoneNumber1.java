package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
public class LetterCombinationsofaPhoneNumber1 {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() ==0){
            return Collections.EMPTY_LIST;
        }
        String[]dic = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> retList = new LinkedList<String>();
        retList.add("");
        while(retList.peek().length() != digits.length()){
            String pop = retList.pop();
            for(char cc : dic[digits.charAt(pop.length()) - '0'].toCharArray()){
                retList.add(pop+cc);
            }
        }
        return retList;
    }

}
