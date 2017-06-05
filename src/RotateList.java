/**
 * @author boyang.lby
 * @date 6/5/17
 * @description
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        ListNode p = head;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
        k = k % len;
        p = head;
        ListNode p2 = head;
        int p1 = 0;
        while(p.next != null){
            p1++;
            if(p1 > k){
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = head;
        ListNode ret = p2.next;
        p2.next = null;
        return ret;
    }
}
