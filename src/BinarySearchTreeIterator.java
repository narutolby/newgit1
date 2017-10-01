import java.util.Stack;

/**
 * @author boyang.lby
 * @date 9/26/17
 * @description
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.


>>>>>>> ea808c22af69a9b1b63ec3a4e2b7cd74b6eb6432
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BinarySearchTreeIterator(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        addAllLeft(stack,root);
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

    public void addAllLeft(Stack<TreeNode> stack,TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

}
