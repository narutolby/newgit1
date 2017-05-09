package contest31;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 5/7/17
 * @description
 */
public class SubtreeofAnotherTree {
    boolean ret = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        inorder(s,t);
        return ret;
    }

    public void inorder(TreeNode s,TreeNode t){
        if(s == null){
            return;
        }
        if(s.val == t.val){
            boolean isSame = isSameTree(s,t);
            if(isSame){
                ret = true;
                return;
            }
        }
        if(!ret){
            inorder(s.left,t);
        }
        if(!ret){
            inorder(s.right,t);
        }

    }

    boolean isSameTree(TreeNode s, TreeNode t){
        if(s == t){
            return true;
        }
        if(s == null && t != null || s != null && t== null || s.val != t.val){
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }


}
