package google.usefullquestion;CEO为根节点，底下有员工，求员工和CEO的最远距离，实际上就是求树的深度
内存问题：DFS可能爆栈，BFS不存在内存问题。
104. Maximum Depth of Binary Tree
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null)
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
//iterative O(n) time, O(n) space
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int max=0;
        while(!queue.isEmpty()){
            ++max;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
        }
        return max;
    }
}
//recursive O(n) time, O(h) space
//top down
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {//corner case !!!
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;//should be 1, not 0 !!!
        }
        if (root.left == null) {
            return maxDepth(root.right) + 1;
        }
        if (root.right == null) {
            return maxDepth(root.left) + 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
//bottom up
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

