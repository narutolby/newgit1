import java.util.Stack;

/**
 * @author boyang.lby
 * @date 5/16/17
 * @description
 */
public class SimplyPath {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return path;
        }
        String[]strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            if(str.equals(""))continue;
            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!str.equals(".")){
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0){
            stack.push("");
        }
        for(int i=0;i<stack.size();i++){
            sb.append("/").append(stack.get(i));
        }
        return sb.toString();
    }
}

