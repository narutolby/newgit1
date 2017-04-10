/**
 * @author boyang.lby
 * @date 4/10/17
 * @description
 */
public class BalancedBinaryTree {
    boolean ret = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        inOrder(root);
        return ret;

    }
    public int inOrder(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        int left = inOrder(node.left);
        int right = inOrder(node.right);
        if(Math.abs(left-right)>1){
            ret = false;
            return 0;
        }
        return Math.max(left,right) + 1;
    }
}
