package google.usefullquestion;

public class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(int[] p:points){
            max = Math.max(max,p[0]);
            min = Math.min(min,p[0]);
            String str = p[0] + "a" + p[1];
            set.add(str);
        }
        int sum = max+min;
        for(int[] p:points){
            //int[] arr = {sum-p[0],p[1]};
            String str = (sum-p[0]) + "a" + p[1];
            if( !set.contains(str))
                return false;
            
        }
        return true;
    }
}
 任意直线：对于每一个点对，计算其垂直平分线，用约分的(a,b,c)表示唯一的直线ax+by+c=0，对于所有n^2的点对，用(a,b,c)作key来用hashtable分组，最后看看是不是有哪一组包含所有的点。
     
     点在对称轴的情况： 1个点在对称轴，算两遍就行，找另一个点再算
                    2个点在对称轴，那么两个点可以确定一条直线，还是能找到