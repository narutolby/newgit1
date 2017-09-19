package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author boyang.lby
 * @date 9/19/17
 * @description
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if(n == 0){
            return list;
        }
        helper(list,0,0,n,"");
        return list;
    }

    public void helper(List<String> ret,int l,int p,int n,String s){
        if(l == p && l == n){
            ret.add(s);
            return ;
        }
        if(l<3){
            helper(ret, l + 1, p, n, s + "(");
        }
        if(p<l){
            helper(ret,l,p+1,n,s + ")");
        }
    }
}
