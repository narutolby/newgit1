package contest45;

import java.util.HashSet;
import java.util.Set;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 8/20/17
 * @description
 */
public class EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        dfs(root,set);
        if(root.val %2 == 0 && set.contains(root.val/2)){
            return true;
        }
        return false;
    }
    public int dfs(TreeNode root,Set<Integer> set){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left,set);
        int right = dfs(root.right,set);
        root.val += left + right;
        set.add(root.val);
        return root.val;
    }
}
