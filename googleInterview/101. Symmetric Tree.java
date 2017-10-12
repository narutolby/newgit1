package google.usefullquestion;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }
    
    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
follow up是如果有left, mid, right三个child怎么办:
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(root);
        queue2.offer(root);
        while(!queue1.isEmpty()){
            int size=queue1.size();
            for(int i=0;i<size;i++){
                TreeNode cur1=queue1.poll();
                TreeNode cur2=queue2.poll();
                //这里就写了两种情况，面试时把所有的情况必须写全
                if(cur1.left!=null&&cur2.right==null) return false;
                if(cur1.right!=null&&cur2.left==null) return false;
                
                if(cur1.val!=cur2.val) return false;
                if(cur1.left!=null) queue1.offer(cur.left);
                if(cur1.mid!=null) queue1.offer(cur.mid);
                if(cur1.right!=null) queue1.offer(cur.right);
                if(cur2.right!=null) queue2.offer(cur.left);
                if(cur2.mid!=null) queue2.offer(cur.mid);
                if(cur2.left!=null) queue2.offer(cur.right);
            }
        }
        return true;
    }
}