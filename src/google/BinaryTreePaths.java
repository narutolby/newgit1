package google;

import java.util.ArrayList;
import java.util.List;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 10/3/17
 * @description
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);
        for (String str : leftList) {
            list.add(root.val + "->" + str);
        }
        for (String str : rightList) {
            list.add(root.val + "->" + str);
        }
        return list;
    }
}

