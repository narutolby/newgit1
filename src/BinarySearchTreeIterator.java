import java.util.Stack;

/**
 * @author boyang.lby
 * @date 9/26/17
 * @description
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BinarySearchTreeIterator(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode small = stack.pop();
        int val = small.val;
        if(small.right != null){
            small = small.right;
            while(small != null){
                stack.push(small);
                small = small.left;
            }
        }
        return val;
    }
}
