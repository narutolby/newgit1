package google.usefullquestion;

public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        for(int i=0; i<nums.length-1; i++) {
            maxNext = Math.max(maxNext, i+nums[i]);
            if( i == curMaxArea ) {
                step++;
                curMaxArea = maxNext;
            } 
        }
        return step;
    }
}
2 3 1 1 4 
2 -> start
    3 1 first step range, so 1 update curMaxArea
        1 4 second step range so 4 update curMaxArea
    
print 走了几步：step是接着上面step的。
    public static List<String> helper(int[] nums){
		List<String> res=new ArrayList<>();
	    dfs(res,nums,"",step,0);
	    return res;
	}
	public static void dfs(List<String> res,int[] nums,String s,int level,int start){
	    if(level<0) return;
	    s=s+start;
	    if(level==0&&start == nums.length - 1){
	        res.add(s);
	        return;
	    }
	    for(int i=1;i<=nums[start];i++){
	        dfs(res,nums,s,level-1,start+i);
	    }
	}
