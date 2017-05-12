/**
 * @author boyang.lby
 * @date 5/12/17
 * @description
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode _head = new ListNode(0);
        _head.next = head;
        ListNode p = _head;
        ListNode q = _head;
        while(p.next != null){
            boolean cut = false;
            if(p.next.val < x){
                if(q.next != p.next){
                    ListNode n = q.next;
                    q.next = p.next;
                    p.next = p.next.next;
                    q.next.next = n;
                    cut = true;
                }
                q = q.next;
            }
            if(!cut){
                p = p.next;
            }

        }
        return _head.next;
    }
}
