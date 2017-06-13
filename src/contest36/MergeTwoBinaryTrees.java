package contest36;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 6/11/17
 * @description
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        return postOrder(t1, t2);
    }

    public TreeNode postOrder(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return null;
        }
        TreeNode n;
        TreeNode left = null,right = null;
        if(t1 == null){
            n = new TreeNode(t2.val);
            left = postOrder(null, t2.left);
            right = postOrder(null, t2.right);

        }else if(t2 == null){
            n = new TreeNode(t1.val);
            left = postOrder(t1.left, null );
            right = postOrder(t1.right, null);
        }else{
            n = new TreeNode(t2.val+t1.val);
            left = postOrder(t1.left, t2.left);
            right = postOrder(t1.right,t2.right);
        }
        n.left = left;
        n.right = right;
        return n;

    }

}
