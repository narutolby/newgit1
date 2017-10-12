package google.usefullquestion;//此题思路：把所有点放进set中，找矩形，找对角线。两个点，确定一条对角线，然后对角线作为直径画圆，找出可以形成的矩形，因为在圆上的点距离圆心的距离等于半径，可以找到一个点，然后根据这个点，和圆心的关系，找到另一个点，看两个点是否存在，求面积。

public class &&{    
    class Node{
        int x;
        int y;
        public node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    @Override   
    public boolean equals(Object st)   
    {   
        Node temp= (Node) st;   
        if (x==temp.x&&y==temp.y) return true;   
        else return false;   
    } 
    @Override
    public int hashCode()   
    {   
        return new Integer(x+y).hashCode();   
    }
}
public class Solution {
    public int helper(List<Node> list) {
        int max=0;//维持最大面积
        if(list.size()==0) return 0;
        int count=0;
        HashSet<Node> set=new HashSet<>();
        for(int i=0;i<list.size();i++){
            set.add(list.get(i));
        }
        for(int i=0;i<list.size();i++){
            Node node=list.get(i);
            for(int j=0;j<list.size();j++){
                Node cur=list.get(j);
                //找圆心：
                int midx=(cur.x+node.x)/2;
                int midy=(cur.y+node.y)/2;
                //找半径的平方：伪代码
                int r=Math.squar((node.x-cur.x)^2+(node.y-cur.y)^2);
                for(int k=0;i<list.size();k++){
                    Node temp=list.get(k);
                    if(temp==node||temp==cur) continue;
                    else {
                        //(x-midx)^2+(y-midy)^2==r^2,表示符合条件
                        if((temp.x-midx)-------){//找到一点
                            //找到另一点
                            Node another=new Node(midx*2-temp.x,midy*2-temp.y);
                            if(set.contain(another)){
                                //算面积
                            }
                        }
                    }
                }
            }
            set.remove(node);
        }
        return count;
    }
}