package contest56;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 10/29/17
 * @description
 */
public class StringCompression {


    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        char repeatChar = chars[0];
        int count = 0;
        while(i<chars.length){
            if(chars[i] == repeatChar){
                count++;
            }else{
                stack.push(repeatChar);
                if(count != 1){
                    char[] chars1 = String.valueOf(count).toCharArray();
                    for(char c : chars1){
                        stack.push(c);
                    }
                }
                repeatChar = chars[i];
                count=1;
            }
            i++;
        }
        stack.push(repeatChar);
        if(count != 1){
            char[] chars1 = String.valueOf(count).toCharArray();
            for(char c : chars1){
                stack.push(c);
            }
        }
        for(i=0;i<stack.size();i++){
            chars[i] = stack.get(i);
        }
        return stack.size();
    }
    public static void main(String[]args){
        new StringCompression().compress(new char[]{'a','a','b','b','c','c','c'});
    }
}
