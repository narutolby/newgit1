import java.util.Stack;

/**
 * @author boyang.lby
 * @date 10/1/17
 * @description
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        StringBuilder ret = new StringBuilder();
        int[]map = new int[26];
        boolean[]used = new boolean[26];
        for(int i=0;i<s.length();i++){
            map[s.charAt(i) - 'a']++;
        }
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(used[ch-'a']){
                map[ch-'a']--;
            }else{
                while(!stack.isEmpty() && ch<stack.peek() && map[stack.peek()-'a']>0){
                    char c = stack.pop();
                    used[c-'a'] = false;
                }
                stack.push(ch);
                map[ch-'a']--;
                used[ch-'a']= true;
            }
        }
        for(int i =0;i<stack.size();i++){
            ret.append(stack.get(i));
        }
        return ret.toString();
    }
}
