package contest45;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 8/20/17
 * @description
 */
public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        int ret = Integer.MIN_VALUE;
        Map<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 1;
        map.put(root,0);
        while(!queue.isEmpty()){
            int tmp = 0;
            for(int i=0;i<count;i++){
                TreeNode node = queue.poll();
                min = Math.min(min,map.get(node));
                max = Math.max(max,map.get(node));
                if(node.left != null){
                    tmp++;
                    map.put(node.left,2 * map.get(node));
                    queue.offer(node.left);
                }
                if(node.right != null){
                    tmp++;
                    map.put(node.right,2 * map.get(node) + 1);
                    queue.offer(node.right);
                }
            }
            count = tmp;
            ret = Math.max(ret,max - min + 1);
            min = Integer.MAX_VALUE;max = Integer.MIN_VALUE;
        }
        return ret;
    }
    public static void main(String[]args){

    }
}
