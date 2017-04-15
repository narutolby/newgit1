/**
 * @author boyang.lby
 * @date 4/15/17
 * @description
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return toBST(nums,0,nums.length-1);

    }
    public TreeNode toBST(int[]nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,left,mid-1);
        root.right = toBST(nums,mid+1,right);
        return root;
    }
}
