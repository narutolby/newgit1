package contest90;

import java.util.Stack;

public class ScoreofParentheses {
    public int scoreOfParentheses(String S) {
        int len = S.length();
        if(len == 0){
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        for(char c : S.toCharArray()){
            if(c== '('){
                stack.push(String.valueOf(c));
            }else{
                int sum = 0;
                while(!stack.peek().equals("(")){
                    sum += Integer.valueOf(stack.pop());
                }
                stack.pop();
                if(sum != 0){
                    stack.push(String.valueOf(sum * 2));
                }else{
                    stack.push("1");
                }
            }
        }
        int ret = 0;
        while(!stack.isEmpty()){
            ret += Integer.valueOf(stack.pop());
        }
        return ret;
    }

    public static void main(String[]args){
        System.out.println(new ScoreofParentheses().scoreOfParentheses("(()(()))"));
    }
}
