package contest86;

import java.util.*;

/**
 *
 Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.

 Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.

 Example 1:

 Input: "123456579"
 Output: [123,456,579]
 Example 2:

 Input: "11235813"
 Output: [1,1,2,3,5,8,13]
 Example 3:

 Input: "112358130"
 Output: []
 Explanation: The task is impossible.
 Example 4:

 Input: "0123"
 Output: []
 Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 Example 5:

 Input: "1101111"
 Output: [110, 1, 111]
 Explanation: The output [11, 0, 11, 11] would also be accepted.
 */

public class SplitArrayintoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        if(S == null || S.length() == 0)     {
            return Collections.EMPTY_LIST;
        }
        int len = S.length();
        List<Integer> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len - 2;i++){
            String prefix = S.substring(0,i+1);
            if(prefix.length() >1 && prefix.startsWith("0")){
                continue;
            }
            stack.push(Integer.valueOf(prefix));
            if(dfs(stack,S.substring(i+1))){
                ret.addAll(stack);
                return ret;
            }
            stack.pop();
        }
        return Collections.EMPTY_LIST;
    }
    public boolean dfs(Stack<Integer> stack,String sub){
        if(sub == null||sub.length() == 0){
            return true;
        }
        Integer prefix = stack.peek();
        int len = sub.length();
        for(int i=0;i<len - 2;i++){
            String curent = sub.substring(0,i+1);
            if(curent.length() >1 && curent.startsWith("0")){
                continue;
            }
            String left = sub.substring(i+1);
            if(left.startsWith(String.valueOf(prefix + Integer.valueOf(curent)))){
                stack.push(Integer.valueOf(curent));
                if(dfs(stack,left)){
                    return true;
                }else{
                    stack.pop();
                }
            }else {
                continue;
            }
        }
        return false;
    }

    public static void main(String[]args){
        System.out.println(Arrays.asList(new SplitArrayintoFibonacciSequence().splitIntoFibonacci("123456579")));
    }

}
