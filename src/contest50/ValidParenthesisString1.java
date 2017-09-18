package contest50;

import java.util.Stack;

/**
 * @author boyang.lby
 * @date 9/17/17
 * @description
 */
public class ValidParenthesisString1 {
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        return helper(0,0,0,s);
    }

    public boolean helper(int l,int p,int c,String s){
        if(p > l){
            return false;
        }
        if(c == s.length() ){
            return p == l;
        }
        char cc = s.charAt(c);
        if(cc == '('){
            return helper(l+1,p,c+1,s);
        }else if (cc == ')'){
            return helper(l,p+1,c+1,s);
        }else{
           return helper(l,p,c+1,s) || helper(l+1,p,c+1,s) || helper(l,p+1,c+1,s);
        }
    }


    public static void main(String[]args) {
        System.out.println(new ValidParenthesisString1().checkValidString(")("));
    }
}
