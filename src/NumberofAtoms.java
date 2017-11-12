import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 11/12/17
 * @description
 */
public class NumberofAtoms {
    public String countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        Stack<Pair> stack = new Stack<Pair>();
        List<Pair> list = new ArrayList<Pair>();
        for(char c : formula.toCharArray()){
            if(isUperCase(c) || c == '(' || c == ')'){
                if(list.size()!=0){
                    for(Pair pair:list) {
                        pair.count = pair.count * (num == 0 ? 1 : num);
                        stack.push(pair);
                    }
                    list.clear();
                }else if(sb.length() !=0){
                    stack.push(new Pair(sb.toString(),num == 0?1:num));
                    sb.setLength(0);
                }
                num = 0;
                if(isUperCase(c)){
                    sb.append(c);
                }else if(c == '('){
                    stack.push(new Pair("(",0));
                }else if(c == ')'){
                    while(!stack.peek().atom.equals("(")){
                        list.add(stack.pop());
                    }
                    stack.pop();
                }
            }else if(isLowerCase(c)){
                sb.append(c);
            }else if(isDigit(c)){
                num = num * 10 + c - '0';
            }
        }
        if(list.size()!=0){
            for(Pair pair:list) {
                pair.count = pair.count * (num == 0 ? 1 : num);
                stack.push(pair);
            }
            list.clear();
        }else if(sb.length() !=0){
            stack.push(new Pair(sb.toString(),num == 0?1:num));
            sb.setLength(0);
        }

        TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
        for(Pair pair : stack){
            treeMap.put(pair.atom,treeMap.getOrDefault(pair.atom,0) + pair.count);
        }
        StringBuilder sbret = new StringBuilder();
        for(Map.Entry<String,Integer> entry : treeMap.entrySet()){
            sbret.append(entry.getKey()).append(entry.getValue() == 1 ? "":entry.getValue());
        }
        return sbret.toString();
    }


    boolean isUperCase(char a){
        return a>= 'A' && a<='Z';
    }

    boolean isLowerCase(char a){
        return a>= 'a' && a<='z';
    }

    boolean isDigit(char c){
        return c>='0' && c <='9';
    }


    class Pair{
        String atom;
        int count;
        public Pair(String atom,int count){
            this.atom = atom;
            this.count = count;
        }
    }

    public static void main(String[]args){
        new NumberofAtoms().countOfAtoms("K4(ON(SO3)2)2");
    }
}
