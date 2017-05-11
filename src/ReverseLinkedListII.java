/**
 * @author boyang.lby
 * @date 5/11/17
 * @description
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode pre = null,post = null;
        ListNode s = null,e = null;
        ListNode p = new ListNode(0);
        p.next = head;
        int i = 0;
        if(m == 1){
            pre = p;
        }
        while(head != null){
            i++;
            if(i == m - 1){
                pre = head;
            }
            if(i == m){
                s = head;
            }
            if(i == n){
                e = head;
                post = e.next;
                break;
            }
            head = head.next;
        }

        reverse(s,e,pre,post);
        return p.next;
    }
    public void reverse(ListNode s,ListNode e,ListNode pre,ListNode post){
        ListNode p = null;
        e.next = null;
        ListNode t = s;
        while(s != null){
            ListNode tmp = s;
            s = s.next;
            tmp.next = p;
            p = tmp;
        }
        pre.next = p;
        t.next = post;
    }
    public static void main(String[]args){
        ListNode listNode  = new ListNode(3);
        listNode.next = new ListNode(5);
        new ReverseLinkedListII().reverseBetween(listNode,1,2);
    }
    <T> ListNode reverse(ListNode<T> node){

    }
}
