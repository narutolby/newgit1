import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 5/18/17
 * @description
 */
public class GenerateParentheses {
    Map<String,Integer> map = new HashMap<String,Integer>();
    int c = 1;
    public List<String> generateParenthesis(int n) {
        List<String> retList = new ArrayList<String>();
        if(n == 0){
            return retList;
        }
        Stack<String> stack = new Stack<String>();
        stack.push("(");
        map.put("(",n-1);
        map.put(")",n);
        generate(stack,retList);
        return retList;
    }

    public void generate(Stack<String>stack,List<String> retList){
        if(map.get("(") == 0 && map.get(")") == 0){
            StringBuilder sb = new StringBuilder();
            for(String s : stack){
                sb.append(s);
            }
            retList.add(sb.toString());
            return;
        }
        if(stack.peek().equals("(")){
            if(map.get("(") != 0){
                stack.push("(");
                map.put("(",map.get("(")-1);
                c++;
                generate(stack,retList);
                stack.pop();
                map.put("(",map.get("(")+1);
                c--;
            }
            if(map.get(")") != 0){
                stack.push(")");
                map.put(")",map.get(")")-1);
                c--;
                generate(stack,retList);
                stack.pop();
                map.put(")",map.get(")")+1);
                c++;
            }
        }
        if(stack.peek().equals(")")){
            if(map.get("(") != 0){
                stack.push("(");
                map.put("(",map.get("(")-1);
                c++;
                generate(stack,retList);
                stack.pop();
                map.put("(",map.get("(")+1);
                c--;
            }
            if(c != 0 && map.get(")") != 0){
                stack.push(")");
                map.put(")",map.get(")")-1);
                c--;
                generate(stack,retList);
                stack.pop();
                map.put(")",map.get(")")+1);
                c++;
            }
        }

    }
}
