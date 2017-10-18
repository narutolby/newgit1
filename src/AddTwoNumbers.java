/**
 * @author boyang.lby
 * @date 10/14/17
 * @description
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null || l2 != null || carry != 0){
            int sum = (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val) + carry;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;

    }
}
