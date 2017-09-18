package contest50;

import java.util.Stack;

/**
 * @author boyang.lby
 * @date 9/17/17
 * @description
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        char[]sa = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        return check(stack,sa,0);
    }

    public boolean check(Stack<Character> stack,char[]s,int i){
        if(i == s.length){
            if(stack.isEmpty()){
                return true;
            }
            return false;
        }
        if(s[i] == '*'){
            if(check(stack,s,i+1)){
                return true;
            }
            stack.push('(');
            if(check(stack,s,i+1)){
                return true;
            }
            stack.pop();
            if(!stack.isEmpty()){
                char c = stack.pop();
                if(check(stack,s,i+1)){
                    return true;
                }
                stack.push(c);
            }
        }else if(s[i] == ')'){
            if(stack.isEmpty()){
                return false;
            }
            char c = stack.pop();
            if(check(stack,s,i+1)){
                return true;
            }
            stack.push(c);
        }else{
            stack.push('(');
            if(check(stack,s,i+1)){
                return true;
            }
            stack.pop();
        }
        return false;
    }
    public static void main(String[]args) {
        System.out.println(new ValidParenthesisString().checkValidString("((*)"));
    }
}
