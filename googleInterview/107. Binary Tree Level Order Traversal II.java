package google.usefullquestion;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 用LinkedList创造一个对象mylist，当使用方法add(int index,Object o)后，后退一位，双向链表
 */
//Solution1:
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> wrapList=new LinkedList<List<Integer>>();
        if(root==null) return wrapList;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            List<Integer> subList=new LinkedList<Integer>();
            for(int i=0;i<levelNum;++i){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0,subList);//0是位置，插入到第0位
        }
        return wrapList;
    }
}
//Solution2:
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList=new LinkedList<List<Integer>>();
        levelMaker(wrapList,root,0);
        return wrapList;
    }
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level){
        if(root==null) return;
        if(level>=list.size()){
            list.add(0,new LinkedList<Integer>());
        }
        levelMaker(list,root.left,level+1);
        levelMaker(list,root.right,level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}