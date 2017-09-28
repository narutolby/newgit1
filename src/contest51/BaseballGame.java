package contest51;

import java.util.Stack;

/**
 * @author boyang.lby
 * @date 9/24/17
 * @description
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(String str : ops){
            if(str.equals("+")){
                int r2 = stack.pop();
                int r1 = stack.pop();
                stack.push(r1);
                stack.push(r2);
                stack.push(r1 + r2);
            }else if (str.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(str.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.valueOf(str));
            }
        }
        int sum = 0;
        for(Integer i : stack){
            sum +=i;
        }
        return sum;
    }
    public static void main(String[]args){
        new BaseballGame().calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
    }
}
