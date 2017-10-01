package contest52;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 10/1/17
 * @description
 */
public class LongestUnivaluePath {
    int ret = 0;
    public int longestUnivaluePath(TreeNode root) {
        longest(root);
        return ret;
    }
    public int longest(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        int path = 0,lp = 0,rp = 0;
        if(root.left != null){
            lp = longest(root.left);
            if(root.val == root.left.val){
                lp++;
                path += lp ;
            }else{
                lp = 0;
            }
        }
        if(root.right!= null){
            rp = longest(root.right);
            if(root.val == root.right.val){
                rp++;
                path += rp;
            }else{
                rp = 0;
            }
        }
        ret = Math.max(ret,path);
        return Math.max(lp,rp);
    }
}
