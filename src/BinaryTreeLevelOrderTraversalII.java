import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 4/15/17
 * @description
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> retList = new LinkedList<>();
        if(root == null) return retList;
        List<List<TreeNode>> levelList = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        List<TreeNode> t = new ArrayList<>();
        l.add(root.val);
        t.add(root);
        retList.addFirst(l);
        levelList.add(t);
        for(int i=0;i<levelList.size();i++){
            List<TreeNode> eleList = levelList.get(i);
            List<Integer> newInList = new ArrayList<>();
            List<TreeNode> newTreeList = new ArrayList<>();
            for(TreeNode node : eleList){
                if(node.left != null){
                    newTreeList.add(node.left);
                    newInList.add(node.left.val);
                }
                if(node.right != null){
                    newTreeList.add(node.right);
                    newInList.add(node.right.val);
                }

            }
            if(!newTreeList.isEmpty()){
                levelList.add(newTreeList);
                retList.addFirst(newInList);
            }

        }
        return retList;
    }

}
