/**
 * @author boyang.lby
 * @date 10/19/17
 * @description
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;
        int count = 0;
        ListNode p = head;
        ListNode vh = new ListNode(0);
        vh.next = head;
        ListNode np = vh;
        while(p != null){
            count++;
            if(count > n){
                np = np.next;
            }
            p = p.next;
        }
        if(count < n){
            return head;
        }
        np.next = np.next.next;
        return vh.next;
    }
}
