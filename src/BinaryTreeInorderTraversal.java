import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 3/12/17
 * @description
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode  h = root;
        while(h != null){
            stack.push(h);
            if(h.left == null){
                h = stack.pop();
                ret.add(h.val);
                if(h.right != null){
                    //stack.push(h.right);
                    h = h.right;
                }else{
                    if(stack.isEmpty()){
                        break;
                    }
                    h = stack.pop();
                    h.left = null;
                }
            }else{
                h = h.left;
            }
        }
        return ret;
    }
}
