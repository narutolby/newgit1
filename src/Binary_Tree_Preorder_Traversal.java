import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 3/12/17
 * @description
 */
public class Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode  h = root;
        boolean has = false;
        while(h != null){
            if(!has) {
                ret.add(h.val);
                stack.push(h);
            }else{
                has = false;
            }
            if(h.left == null){
                h = stack.pop();
                if(h.right != null){
                    h = h.right;
                }else{
                    if(stack.isEmpty()){
                        break;
                    }
                    h = stack.peek();
                    h.left = null;
                    has = true;
                }
            }else{
                h = h.left;
            }
        }
        return ret;
    }
}
