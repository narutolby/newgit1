import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

 Note:
 Input contains only lowercase English letters.
 Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 Input length is less than 50,000.
 Example 1:
 Input: "owoztneoer"

 Output: "012"
 Example 2:
 Input: "fviefuro"

 Output: "45"
 */
public class ReconstructOriginalDigitsfromEnglish {
    public String originalDigits(String s) {
        String[]words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
        int[][]map = new int[10][26];
        for(int i=0;i<words.length;i++){
            String word = words[i];
            for(int j=0;j<word.length();j++){
                map[i][word.charAt(j) - 'a']++;
            }
        }
        int[]table = new int[26];
        for(int i=0;i<s.length();i++){
            table[s.charAt(i) - 'a']++;
        }
        Stack<Integer> stack = new Stack<Integer>();
        dfs(0,stack,10,table,map);
        StringBuilder sb = new StringBuilder();
        for(int i : stack){
            sb.append(i);
        }
        return sb.toString();
    }

    public boolean dfs(int s,Stack<Integer> stack,int count,int[]table,int[][]map){
        if(count == 0){
            return true;
        }
        for(int i=s;i<map.length;i++){
            int[]t = map[i];
            if(drop(table,t)){
                stack.push(i);
                if(dfs(s+1,stack,count--,table,map)){
                    return true;
                }
                add(table,t);
                stack.pop();
            }
        }
        return false;
    }
    public boolean drop(int[]t1,int[]t2){
        for(int i=0;i<t1.length;i++){
            if(t1[i] == 0){
                continue;
            }
            if(t1[i]<t2[i]){
                return false;
            }
        }
        for(int i=0;i<t1.length;i++){
            t1[i] -= t2[i];
        }
        return true;
    }

    public void add(int[]t1,int[]t2){
       for(int i=0;i<t1.length;i++){
            t1[i] += t2[i];
       }
    }
}
