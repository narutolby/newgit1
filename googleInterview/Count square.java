package google.usefullquestion;//此题思路：把所有点放进set中，找正方形，找对角线，正方形边长都相等来做
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
                if(Math.abs(node.x-cur.x)!=Math.abs(node.y-cur.y)){
                    continue;
                }
                Node left=new Node(node.x,cur.y);
                Node right=new Node(cur.x,node.y);
                if(set.contain(left)&&set.contain(right)) count++;
            }
            set.remove(node);
        }
        return count;
    }
}