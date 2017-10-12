package google.usefullquestion;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return list;
    }
}

返回所有正确的结果
public class Solution {
    List<String> list = new ArrayList<String>();
    public boolean canWin(List<String> res,String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
            String t = s.substring(0, i) + "--" + s.substring(i + 2);
            if (!canWin(t)) {
                res.add(t);
                return true;
                }
            }
        }
      return false;
    }
}
返回所有可能
public class Solution {
    public static List<List<String>> canWin(String s) {
        List<List<String>> res=new ArrayList<>();
        if (s == null || s.length() < 2) {
            return res;
        }
        helper(res,s,new ArrayList<>(),0);
        return res;
    }
    public static void helper(List<List<String>> res,String s,List<String> list,int count){
        list.add(s);
        for(int i=1;i<s.length();i++){
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                count++;
                String t = s.substring(0, i-1) + "--" + s.substring(i + 1);
                helper(res,t,list,0);
            }
        }
        if(count==0){
            res.add(new ArrayList<>(list));
        }
        list.remove(list.size()-1);
    }
}