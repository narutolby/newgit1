/**
 * @author boyang.lby
 * @date 2/16/18
 * @description
 */
public class MinimumDistanceBetweenBSTNodes {
    int ret = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
       helper(root);
       return ret;
    }

    public void helper(TreeNode root){
        if(root == null) {
            return;
        }
        helper(root.left);
        if(pre == null){
            pre = root;
        }else{
            ret = Math.min(Math.abs(pre.val - root.val),ret);
            pre = root;
        }
        helper(root.right);
    }
}
