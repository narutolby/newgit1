package contest71;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 2/18/18
 * @description
 */
public class MinimumDistanceBetweenBSTNodes {
    int ret = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper(root);
        return ret;
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        if(pre == null){
            pre = root;
        }else{
            ret = Math.min(ret,Math.abs(pre.val - root.val));
            pre = root;
        }
        helper(root.right);
    }

}
