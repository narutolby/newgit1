import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author boyang.lby
 * @date 3/3/18
 * @description
 */
public class FindModeinBinarySearchTree {

    int max = 1;
    Set<Integer> set = new HashSet<Integer>();
    TreeNode pre = null;
    int count = 1;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        inOrder(root);
        Integer[] toArray = set.toArray(new Integer[set.size()]);
        int[]ret = new int[toArray.length];
        for(int i=0;i<toArray.length;i++){
            ret[i] = toArray[i];
        }
        return ret;
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(pre == null){
            pre = root;
        }else{
            if(pre.val != root.val){
                count = 0;
            }
            count++;
        }
        if(count >= max){
            if(count > max){
                set.clear();
                max = count;
            }
            set.add(root.val);
        }
        pre = root;
        inOrder(root.right);
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.left.right.left.right = new TreeNode(2);
        new FindModeinBinarySearchTree().findMode(root);
    }
}
