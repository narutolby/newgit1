package google;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 10/2/17
 * @description
 */
public class KthSmallestElementinaBST {
    int ret = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return ret;
    }
    public int helper(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        int left = helper(root.left, k);
        int right = 0;
        if(left+1 == k){
            ret = root.val;
        }else if(left +1 < k){
            right = helper(root.right,k - left - 1);
        }
        return left + right + 1;
    }
}
