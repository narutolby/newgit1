import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.


 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BinarySearchTreeIterator(TreeNode root) {
        addAllLeft(stack,root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = stack.pop();
        int val = next.val;
        TreeNode right = next.right;
        while(right != null){
            stack.push(right);
            right = right.left;
        }
        return val;
    }

    public void addAllLeft(Stack<TreeNode> stack,TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

}
