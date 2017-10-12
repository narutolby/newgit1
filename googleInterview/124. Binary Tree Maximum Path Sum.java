package google.usefullquestion;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}

max path sum with only k nodes. 
觉得我答得很不好，一开始还说了一个错的解法，三哥说了一个case就知道我错了。最后告诉他暴力解。三哥最后说“I think you are on the right track."
    
    所有k个节点都存起来暴力解，然后蹦出来求最大
路径：
public class Solution {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        List<TreeNode> res=new ArrayList<>();
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root,res);
        return res;
    }
    
    private int maxPathDown(TreeNode node, List<TreeNode> res) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        res.add(node);
        return Math.max(left, right) + node.val;
    }
}