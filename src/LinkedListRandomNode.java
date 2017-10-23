import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

 Follow up:
 What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

 Example:


 // Init a singly linked list [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 solution.getRandom();
 */

public class LinkedListRandomNode {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode p = null;

    public LinkedListRandomNode(ListNode head) {
        this.p = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int ret = 0;
        int count = 0;
        Random random = new Random();
        while(p != null){
            count++;
            int r = random.nextInt(count);
            if(r == count - 1){
                ret = p.val;
            }
            p = p.next;
        }
        return ret;
    }

    public static void main(String[]args){
        Random random = new Random();
        System.out.print(random.nextInt(1));
        System.out.print(random.nextInt(1));
        System.out.print(random.nextInt(1));
        System.out.print(random.nextInt(1));
        System.out.print(random.nextInt(1));
        System.out.print(random.nextInt(1));
    }


    /**
     *
     * Your Solution object will be instantiated and called as such:
     *
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
}
