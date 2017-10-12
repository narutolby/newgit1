package google.usefullquestion;1,原题：
public class Solution {
    public int minDistance(String word1, String word2) {
        //f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
        //f(i, j - 1) represents insert operation
        //f(i - 1, j) represents delete operation
        //f(i - 1, j - 1) represents replace operation
        int m = word1.length();
        int n = word2.length();
        
        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)//f(0, k) = f(k, 0) = k
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;//step+1 because we use one insert/delete/replace
                }
            }
        }
        return cost[m][n];
    }
}
2，abcb -> abbc 也当做没有变化,这样直接统计一下字符出现次数就好了。用char[256],++ --
public class Main {
	public static void main(String[] args) {
		String t="abcd";
		String s="abdcdd";
		int res=test(t,s);
		System.out.println(res);
    }
	//if(t.length()<s.length())
	public static int test(String t,String s){
		int res=0;
		int[] cnt=new int[256];
		for(int i=0;i<s.length();i++){
			cnt[s.charAt(i)]++;
		}
		for(int i=0;i<t.length();i++){
			cnt[t.charAt(i)]--;
		}
		for(int i=0;i<256;i++){
			res+=Math.abs(cnt[i]);
		}
		return res;
	}
}
    
    输出最少的 edit 都是什么
    edit=Integer.MAX_VALUE;指的是最小的更新次数，每次结束一个后比较，比edit小更新edit的值,count 当前更新次数
public static void helper(String s,String t,String cur,int edit,List<List<String>> res,List<String> list,int count){
	    list.add(cur);
	    if(cur.equals(t)){
	        if(count<edit){
	            edit=count;
	            res.clear();
	            res.add(new ArrayList<>(list));
	        }else if(count==edit){
	            res.add(new ArrayList<>(list));
	        }
	    }
	    if (s.charAt(edit) != t.charAt(edit)) {
	        helper(s,t,t.substring(edit)+s.charAt(edit)+t.substring(edit+1),edit,res,list,count++);
	        
	        //加另外两个
	    }
	}
backtracking:
public void helper(String s,String t,String cur){
    if(cur.equals(s)){
        // 返回的是cur
        return;
    }
    for(int i=0;i<count;i++){
        //看one edit distance.
    }
}