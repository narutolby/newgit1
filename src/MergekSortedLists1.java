import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node : lists){
            if(node != null){
                priorityQueue.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            if(node.next != null){
                priorityQueue.add(node.next);
                node.next = null;
            }
            p.next = node;
            p = p.next;
        }
        return head.next;
    }
}
