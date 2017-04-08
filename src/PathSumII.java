import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 4/8/17
 * @description
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        Stack<Integer> stack = new Stack<>();
        inOrder(root,stack,sum,retList);
        return retList;
    }
    public void inOrder(TreeNode node ,Stack<Integer> stack,int remain,List<List<Integer>> retList){
        if(node == null) return;
        stack.push(node.val);
        if(remain == node.val && node.left == null && node.right == null){
            List<Integer> list = new ArrayList<>();
            list.addAll(stack);
            retList.add(list);
            stack.pop();
            return;
        }

        inOrder(node.left,stack,remain-node.val,retList);
        inOrder(node.right,stack,remain-node.val,retList);
        stack.pop();
    }
}
