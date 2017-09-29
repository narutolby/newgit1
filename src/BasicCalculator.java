import java.util.LinkedList;
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
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Character> os = new Stack<Character>();
        Stack<Integer> is = new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }else if(c == '('){
                os.push(c);
            } else if(c == '+' || c == '-'){
                while(!os.isEmpty() && (os.peek() == '+' || os.peek() == '-')){
                    if(os.pop() == '+'){
                        is.push(is.pop() + is.pop());
                    }else{
                        is.push(0 - is.pop() + is.pop());
                    }
                }
                os.push(c);
            }else if(c == ')'){
                while(os.peek() != '('){
                    char d = os.pop();
                    if(d =='+'){
                        is.push(is.pop() + is.pop());
                    }else{
                        is.push(0 - is.pop() + is.pop());
                    }
                }
                os.pop();
            }else{
                int i0 = i;
                while(i0<s.length() && s.charAt(i0)>='0' && s.charAt(i0)<='9'){
                    i0++;
                }
                is.push(Integer.valueOf(s.substring(i,i0)));
                i = i0-1;
            }
        }
        int ret = 0;
        while(!os.isEmpty()){
            char cc = os.pop();
            if(cc == '+'){
                is.push(is.pop() + is.pop());
            }else{
                is.push(0-is.pop() + is.pop());
            }
        }
        while(!is.isEmpty()){
            ret += is.pop();
        }
        return ret;
    }

    public static void main(String[]args){
        System.out.println(new BasicCalculator().calculate("2-(5-6)"));
    }
}
