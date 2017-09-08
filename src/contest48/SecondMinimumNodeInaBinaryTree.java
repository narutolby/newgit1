package contest48;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 9/3/17
 * @description
 */
public class SecondMinimumNodeInaBinaryTree {
    int one = Integer.MAX_VALUE - 1;
    int second = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || (root.left == null && root.right == null) ){
            return -1;
        }
        dfs(root);
        if(one != second && second != Integer.MAX_VALUE - 1){
            return second;
        }
        return -1;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        update(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public void update(int val){
        if(val < one){
            second = one;
            one = val;
        }else if(val < second && val != one){
            second = val;
        }
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right= new TreeNode(2);
        System.out.println(new SecondMinimumNodeInaBinaryTree().findSecondMinimumValue(root));
    }
}
