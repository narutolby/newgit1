package contest48;

import java.util.ArrayList;
import java.util.List;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 9/3/17
 * @description
 */
public class TrimaBinarySearchTree1 {
    TreeNode ret = null;
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)    {
            return root;
        }
        dfs(root,L,R,null);
        return ret;
    }
    public void dfs(TreeNode root,int l,int r,TreeNode p){
        if(root == null){
            return ;
        }

        if(root.val >= l && root.val <= r){
            if(ret != null){
                ret = root;
            }
            dfs(root.left,l,r,root);
            dfs(root.right,l,r,root);
        }else if(root.val > r){
            if(p != null){
                p.right = root.left;
            }
            dfs(root.left,l,r,p);
        }else{
            if(p != null){
                p.left = root.right;
            }
            dfs(root.right,l,r,p);
        }
    }


    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right= new TreeNode(2);
        System.out.println(new TrimaBinarySearchTree1().trimBST(root, 1, 2));
    }
}
