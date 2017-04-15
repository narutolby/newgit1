import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 4/15/17
 * @description
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if(root == null) return retList;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int levelNumber = 1;
        while(!queue.isEmpty()){
            levelNumber = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0;i<levelNumber;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                list.addLast(node.val);
            }
            retList.add(list);
        }
        return retList;
    }
}
