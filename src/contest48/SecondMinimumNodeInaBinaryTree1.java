package contest48;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 9/3/17
 * @description
 */
public class SecondMinimumNodeInaBinaryTree1 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || (root.left == null && root.right == null) ){
            return -1;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        dfs(root,set);
        if(set.size() < 2){
            return -1;
        }
        return (int)set.toArray()[1];
    }

    public void dfs(TreeNode root,Set<Integer> set){
        if(root == null){
            return ;
        }
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right,set);
    }


    public static void main(String[]args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right= new TreeNode(4);
        System.out.println(new SecondMinimumNodeInaBinaryTree1().findSecondMinimumValue(root));
    }
}
