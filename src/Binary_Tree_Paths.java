import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 2/27/17
 * @description
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

1
/   \
2     3
\
5
All root-to-leaf paths are:

["1->2->5", "1->3"]
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retList = new ArrayList<String>();
        if(root == null) return retList;
        String val = null;
        inOrder(root,val,retList);
        return retList;
    }

    public void inOrder(TreeNode node,String val,List<String>list){
        if(node == null){
            return;
        }
        if(val == null){
            val = String.valueOf(node.val);
        }else{
            val += "->" + node.val;
        }
        if(node.left == null && node.right == null){
            list.add(val);
            return;
        }
        inOrder(node.left,val,list);
        inOrder(node.right,val,list);
    }
}

