/**
 * @author boyang.lby
 * @date 2/10/18
 * @description
 */
public class LongestUnivaluePath1 {
    int ret = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return ret;
    }
    public int helper(TreeNode root) {
        if(root == null ){
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 0;
        }
        int leftPath = 0,rightPath = 0;
        leftPath = helper(root.left);
        rightPath = helper(root.right);
        leftPath = root.left!=null && root.left.val == root.val ? leftPath + 1:0;
        rightPath = root.right!=null && root.right.val == root.val ? rightPath+ 1:0;
        ret = Math.max(ret,leftPath + rightPath);
        return Math.max(leftPath,rightPath);
    }
}
