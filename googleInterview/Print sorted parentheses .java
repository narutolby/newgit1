package google.usefullquestion;
输入下列字符串
（（）（））（）（）
输出
[（0，5），（1，2），（3，4），（6，7），（8，9）] 必须按照这个顺序输出
public class Main {
	public static void main(String[] args) {
		String s="(()())()";
		List<List<Integer>> res=test(s);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
		
    }
	public static List<List<Integer>> test(String s){
	    Stack<Integer> stack=new Stack<>();
	    List<List<Integer>> res=new ArrayList<>();
	    int count=0;
	    for(int i=0;i<s.length();i++){
	        if(s.charAt(i)=='('){
	            List<Integer> tmp=new ArrayList<>();
	            tmp.add(i);
	            stack.push(count);
	            res.add(tmp);
	            count++;
	        }else{
	            res.get(stack.pop()).add(i);
	        }
	    }
	    return res;
	}
}

http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=216907&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311