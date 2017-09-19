package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 9/19/17
 * @description
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap(){
            {
                put(')','(');
                put('}','{');
                put(']','[');
            }
        };
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(stack.isEmpty() || map.get(c) != stack.peek()){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
