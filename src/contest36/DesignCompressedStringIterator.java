package contest36;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 6/11/17
 * @description
 */
public class DesignCompressedStringIterator {

    Stack<Character> stack = new Stack<Character>();
    Stack<Integer> stack1 = new Stack<Integer>();
    int nn = -1;

    public DesignCompressedStringIterator(String compressedString) {
        if (compressedString == null || compressedString.length() == 0) {
            return;
        }
        char[] chars = compressedString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= chars.length; i++) {
            char c;
            if(i<chars.length){
                c = chars[i];
            }else{
                c = (char)-1;
            }
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || i == chars.length) {
                if (sb.length() != 0) {
                    Integer n = Integer.valueOf(sb.toString());
                    stack1.push(n);
                }
                if(i != chars.length){
                    stack.push(c);
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        Stack<Character> stack3 = new Stack<Character>();
        Stack<Integer> stack4 = new Stack<Integer>();
        while(!stack.isEmpty()){
            stack3.push(stack.pop());
            stack4.push(stack1.pop());
        }
        stack = stack3;
        stack1 = stack4;

    }

    public char next() {
        if (stack.isEmpty()) {
            return ' ';
        }
        Integer n = stack1.pop();
        if(n != 1){
            stack1.push(n-1);
            return stack.peek();
        }else{
            return stack.pop();
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new DesignCompressedStringIterator("L1e2t1C1o1d1e1").next());
    }
}
