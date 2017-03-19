/**
 * @author boyang.lby
 * @date 3/12/17
 * @description
 */
public class LowestCommonAncestorofaBinarySearchTree {

    private TreeNode  ret = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        inOrder(root,p,q);
        return ret;
    }

    public boolean inOrder(TreeNode root, TreeNode p,TreeNode q){
        if(root == null) {
            return false;
        }
        if(root.val >= p.val && root.val<= q.val || root.val <=p.val && root.val >= q.val){
            ret = root;
            return true;
        }

        if(root.val < p.val && root.val < q.val){
            if(inOrder(root.right,p,q)){
                return true;
            }
        }

        return inOrder(root.left,p,q);

    }

}
