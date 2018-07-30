package contest95;

public class MiddleoftheLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head,p2 = head;
        while(p1 != null && p2!=null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1;
    }

    public static void main(String[]args){

    }
}
