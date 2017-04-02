/**
 * @author boyang.lby
 * @date 4/2/17
 * @description
 */
public class BinaryTreeMaximumPathSum {

    int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        inOrder(root);
        return ret;
    }

    public int inOrder(TreeNode root){
        if(root == null){
            return 0;
        }
        int pathSum = root.val;
        int leftPathSum = inOrder(root.left);
        int rightPathSum = inOrder(root.right);
        if(leftPathSum > 0){
            pathSum += leftPathSum;
        }
        if(rightPathSum > 0){
            pathSum += rightPathSum;
        }
        ret = Math.max(ret,pathSum);
        return Math.max(Math.max(leftPathSum,rightPathSum) + root.val,root.val);
    }
}
