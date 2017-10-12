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
    public List<TreeNode> maxPathSum(TreeNode root) {
        List<TreeNode> res=new ArrayList<>();
        if(root==null) return res;
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root, List<TreeNode> res){
        if(root==null) return;
        if(shouldbeerased(root)){
            helper(root.left,res);
            helper(root.right,res);
        }else{
            res.add(root);
        }
    }
}
其实就是看当前节点以及父节点是不是被删除，返回的是该子树中的树集合，如果父节点子节点都被删除，递归右子树和左子树，如果子节点没被删除，加入子节点到答案，递归左右节点，如果父节点没被删除，子节点没被删除，继续递归左右子树，子节点被删除，则处理下父节点，再继续递归
