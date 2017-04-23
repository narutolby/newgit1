package contest29;

/**
 * @author boyang.lby
 * @date 4/23/17
 * @description
 */
public class BinaryTreeTilt {
    int ret = 0;
    public int findTilt(TreeNode root) {
        inOrder(root);
        return ret;
    }


    public int inOrder(TreeNode root){
        if(root == null){
            return 0;
        }

        int lv = inOrder(root.left);
        int rv = inOrder(root.right);
        ret += Math.abs(lv-rv);
        return root.val + lv + rv;
    }
}
