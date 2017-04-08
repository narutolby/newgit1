/**
 * @author boyang.lby
 * @date 4/8/17
 * @description
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode head = new TreeNode(0);
        inOrder(root,head);


    }
    public TreeNode inOrder(TreeNode node,TreeNode head){
        if(node == null){
            return head;
        }
        TreeNode right = node.right;
        head.right = node;
        head = inOrder(node.left,head.right);
        node.left = null;
        head = inOrder(right,head);
        return head;

    }
}
