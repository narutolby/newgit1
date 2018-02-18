package contest69;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 2/18/18
 * @description
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        if(S == null || S.length() == 0){
            ret.add("");
            return ret;
        }
        helper(S.toCharArray(),0,ret,"");
        return ret;
    }

    public void helper(char[]chars,int i,List<String> ret,String s){
        if(i == chars.length){
            ret.add(s);
            return;
        }
        char c = chars[i];
        helper(chars,i+1,ret,s+c);
        if(c >= 'a' && c <= 'z'){
            helper(chars,i+1,ret,s+(char)(c-32));
        }else if(c >='A' && c<='Z'){
            helper(chars,i+1,ret,s+(char)(c+32));
        }
    }
}
