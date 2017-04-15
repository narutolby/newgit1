/**
 * @author boyang.lby
 * @date 4/15/17
 * @description
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null)return true;
        if(t1 == null && t2 != null || t2 == null && t1 != null || t2.val != t1.val) return false;
        return isSymmetric(t1.left,t2.right) && isSymmetric(t1.right,t2.left);
    }
}
