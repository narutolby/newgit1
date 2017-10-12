package google.usefullquestion;O(m*n+n)
public class Solution {
    class node{
        int x;
        int y;
        public node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int helper(int[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
        List<Node> res=new ArrayList<>();
        int[] col=new int[grid[0].length];//col[i]的值指的是出现黑色点到第几行，i代表出现黑色点的第几列
        for(int i=0;i<grid.length;i++){//m*n
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){//找个黑色
                    if(col[j]==0){//第一次出现
                        col[j]=i+1;//第0行没有办法处理，因为初始化为0，所以+1
                    }else if(col[j]!=0){//出现两次，不符合条件
                        col[j]=-1;
                    }
                }
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(col[i]!=0&&col[i]!=-1){
                res.add(new Node(col[i]-1,i));
            }
        }
        return res;
    }
}
follow up:
这回给定参数 N， 要找的黑pixel需要满足，他所在的行列只有N个黑pixel， 并且N行中 不同的行 中的 黑pixel 的位置需要相同
class node{
    int count;
    int rowCount;
    public node(int count,int rowCount){
        this.count=count;//一行中有多少个黑色的pixel
        this.rowCount=rowCount;
    }
}
public class Main {
    public static boolean helper(int[][] grid,int N) {
        if(grid == null || grid.length == 0 ||  grid[0].length == 0) return false;
        HashMap<String,node> map=new HashMap<>();//string, 把符合条件的行化为string
        int[] col=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            String s="";
            int count=0;
            for(int j=0;j<grid[0].length;j++){
                s=s+grid[i][j];
                if(grid[i][j]==1){
                    count++;
                    col[j]++;
                }
                if(j==grid[0].length-1){
                    if(map.containsKey(s)){
                        map.get(s).rowCount++;
                    }else{
                        map.put(s,new node(count,1));
                    }
                }
            }
        }
        for(String s:map.keySet()){
        	if(map.get(s).count!=map.get(s).rowCount||map.get(s).count!=N||map.get(s).rowCount!=N){
        		return false;
        	}
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'&&col[i]!=N){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) 
    {
    	int[][] nums={{1,1,0,1},{0,0,0,0},{1,1,0,1},{1,1,0,1}};
    	boolean s=helper(nums,3);
    	System.out.println(s);
    }
}
