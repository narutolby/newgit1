package google;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculator2 {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int sign = 1;
        int num = 0;
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isDigit(c)){
                num = num * 10 + c - '0';
            }
            if (!isDigit(c) && c != ' ' || i == s.length() - 1){
                if(c == '+'){
                    ret += sign * num;
                    sign = 1;
                }else if(c == '-'){
                    ret += sign * num;
                    sign = -1;
                }else if(c == '('){
                    stack.push(ret);
                    stack.push(sign);
                    sign = 1;
                    ret = 0;
                }else if(c == ')'){
                    ret+= sign * num;
                    ret = stack.pop() * ret;
                    ret += stack.pop();
                }else{
                    ret += sign * num;
                }
                num = 0;
            }
        }
        return ret;

    }
    public boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String[]args){
        System.out.println(new BasicCalculator2().calculate("2-(5-6)"));
    }
}
