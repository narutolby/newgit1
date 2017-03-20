import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 3/20/17
 * @description
 */
public class PalindromePartitioning {


    public List<List<String>> partition(String s) {
        boolean[][]isPalindrom = new boolean[s.length()][s.length()];
        List<List<String>> retList = new ArrayList<List<String>>();
        Stack<String> stack = new Stack<String>();
        recursivePartion(s,0,isPalindrom,stack,retList);
        return retList;
    }
    public void recursivePartion(String s,int start,boolean[][]isPalindrom,Stack<String> stack,List<List<String>> retList){
        if(start >= s.length()){
            List<String> tmpList = new ArrayList<String>();
            tmpList.addAll(stack);
            retList.add(tmpList);
            return;
        }
        for(int i = start;i<s.length();i++){
            if(s.charAt(start) == s.charAt(i) && (i - start < 2 || isPalindrom[start+1][i-1])){
                isPalindrom[start][i] = true;
                stack.push(s.substring(start,i+1));
                recursivePartion(s,i+1,isPalindrom,stack,retList);
                stack.pop();
            }
        }
    }


    public static void main(String[]args){
        String a = "asb";
        System.out.println(a.substring(0,0));
    }

}
