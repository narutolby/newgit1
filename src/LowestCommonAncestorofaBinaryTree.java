/**
 * @author boyang.lby
 * @date 3/12/17
 * @description
 */
public class LowestCommonAncestorofaBinaryTree {

    private TreeNode ret = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        hasTreeNodeCounts(root,p,q);
        return ret;
    }

    public int hasTreeNodeCounts(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root == p || root == q){
            count ++;
        }
        int leftCount = hasTreeNodeCounts(root.left,p,q);
        if(leftCount == 2){
            return 2;
        }
        int rightCount = hasTreeNodeCounts(root.right,p,q);
        if(rightCount == 2){
            return 2;
        }
        if(count + leftCount == 2 || count + rightCount == 2 || leftCount + rightCount == 2){
            ret = root;
            return 2;
        }
        return count + leftCount + rightCount;
    }


}
