/**
 * @author boyang.lby
 * @date 4/13/17
 * @description
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head,ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head,slow);
        root.right = toBST(slow.next,tail);
        return root;
    }
}
