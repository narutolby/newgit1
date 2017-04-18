/**
 * @author boyang.lby
 * @date 4/18/17
 * @description
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        return validBST(root,Long.MIN_VALUE ,Long.MAX_VALUE);
    }

    public boolean validBST(TreeNode root,long min ,long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max){
            return false;
        }
        return validBST(root.left,min,root.val) && validBST(root.right,root.val,max);
    }
}
