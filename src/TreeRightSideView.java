import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> retList = new ArrayList<Integer>();
        if(root == null){
            return retList;
        }

        List<List<TreeNode>> treeList = new ArrayList<List<TreeNode>>();
        List<TreeNode> layerList = new ArrayList<TreeNode>();
        layerList.add(root);
        treeList.add(layerList);
        for(int i=0;i<treeList.size();i++){
            List<TreeNode> tmpList = new ArrayList<TreeNode>();
            List<TreeNode> l = treeList.get(i);
            for(TreeNode treeNode : l){
                if(treeNode.left != null){
                    tmpList.add(treeNode.left);
                }
                if(treeNode.right != null){
                    tmpList.add(treeNode.right);
                }
            }
            if(!tmpList.isEmpty()){
                treeList.add(tmpList);
            }
        }
        for(List<TreeNode> l : treeList){
            retList.add(l.get(l.size()-1).val);
        }

        return retList;

    }
}
