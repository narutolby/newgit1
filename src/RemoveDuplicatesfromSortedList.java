/**
 * @author boyang.lby
 * @date 5/15/17
 * @description
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode p = head;
        while(p != null){
            ListNode cur = p;
            while(cur.next != null && p.val == cur.next.val){
                cur = cur.next;
            }
            p.next = cur.next;
            p = p.next;
        }
        return head;
    }
}
