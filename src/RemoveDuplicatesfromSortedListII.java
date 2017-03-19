/**
 * @author boyang.lby
 * @date 3/19/17
 * @description
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode _head = new ListNode(0);
        _head.next = head;
        ListNode p1;
        ListNode p2;
        ListNode p = _head;
        int distance = 1;
        while(head.next != null){
            p1 = head;
            p2 = head.next;
            while(p2.val == p1.val){
                p2 = p2.next;
                distance++;
                if(p2 == null){
                    p.next = null;
                    return _head.next;
                }
            }
            if(distance == 1){
                p.next = p1;
                p = p1;
                head = p2;
            }else{
                p.next = p2;
                head = p2;
                distance = 1;
            }
        }

        return _head.next;
    }
}
