import java.util.Stack;

/**
 * @author boyang.lby
 * @date 10/4/17
 * @description
 */
public class DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        String ret = "";
        int num = 0;
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isDigit(c)){
                num = num * 10 + c - '0';
            }else{
                if(c == '['){
                    stack.push(ret);
                    stack.push(num + "");
                    ret = "";
                    num = 0;
                }else if(c == ']'){
                    int repeat = Integer.valueOf(stack.pop());
                    StringBuilder sb = new StringBuilder();
                    while(repeat-- > 0){
                        sb.append(ret);
                    }
                    ret = stack.pop() + sb.toString();
                }else{
                    ret += c;
                }
            }
        }
        return ret;
    }
    public boolean isDigit(char c){
        return c>='0' && c<='9';
    }
}
