import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 4/15/17
 * @description
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if(root == null) return retList;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int levelNumber = 1;
        int level = -1;
        while(!queue.isEmpty()){
            levelNumber = queue.size();
            level++;
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0;i<levelNumber;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(level % 2 == 0){
                    list.addLast(node.val);
                }else{
                    list.addFirst(node.val);
                }
            }
            retList.add(list);
        }
        return retList;

    }
}
