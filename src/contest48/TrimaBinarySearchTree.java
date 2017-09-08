package contest48;

import java.util.ArrayList;
import java.util.List;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 9/3/17
 * @description
 */
public class TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)    {
            return root;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root,list,L,R);
        return buildTree(list,0,list.size() - 1);
    }
    public void dfs(TreeNode root,List<TreeNode> list,int l,int r){
        if(root == null){
            return ;
        }

        dfs(root.left,list,l,r);
        if(root.val >= l && root.val <= r){
            list.add(root);
        }
        dfs(root.right,list,l,r);
    }

    public TreeNode buildTree(List<TreeNode> list,int l,int r){
        if(l>r){
            return null;
        }
        int mid = (l + r)/2;
        TreeNode root = list.get(mid);
        root.left = buildTree(list,l,mid-1);
        root.right = buildTree(list,mid+1,r);
        return root;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right= new TreeNode(2);
        System.out.println(new TrimaBinarySearchTree().trimBST(root,1,2));
    }
}
