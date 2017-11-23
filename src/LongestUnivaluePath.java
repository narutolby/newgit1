/**
 * @author boyang.lby
 * @date 11/23/17
 * @description
 */
public class LongestUnivaluePath {
    int ret = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return ret - 1;
    }

    public int helper(TreeNode root){
        if(root.left == null && root.right == null){
            ret = Math.max(ret,1);
            return 1;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int ret = 1;
        if(root.left != null && root.val == root.left.val){
            ret += left;
        }
        if(root.right != null && root.val == root.right.val){
            ret += right;
        }
        this.ret = Math.max(ret,this.ret);
        return root.left != null && root.right != null && root.left.val == root.val && root.right.val == root.val ?
            Math.max(left,right) + 1 : ret;
    }
}
