package contest37;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 6/18/17
 * @description
 */
public class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null){
            return null;
        }
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        List<List<TreeNode>> retList = new ArrayList<List<TreeNode>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int levelNumber = 1;
        while(!queue.isEmpty()) {
            levelNumber = queue.size();
            LinkedList<TreeNode> list = new LinkedList<TreeNode>();
            for (int i = 0; i < levelNumber; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.addLast(node);
            }
            retList.add(list);
        }
        List<TreeNode> treeNodeLinkedList = retList.get(d-2);
        for(TreeNode node : treeNodeLinkedList){
            TreeNode newLeftNode = new TreeNode(v);
            TreeNode newRightNode = new TreeNode(v);
            newLeftNode.left = node.left;
            newRightNode.right = node.right;
            node.left = newLeftNode;
            node.right = newRightNode;
        }
        return root;
    }

}
