import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 5/17/17
 * @description
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int len = lists.length;
        List<ListNode> newList = new ArrayList<ListNode>();
        for(int i=0;i<len;i++){
            if(lists[i] != null){
                newList.add(lists[i]);
            }
        }
        if(newList.isEmpty()){
            return null;
        }
        ListNode[] n = new ListNode[newList.size()];
        lists = newList.toArray(n);
        ListNode head = new ListNode(0);
        ListNode p = head;
        buildMinHeap(lists);
        while(len != 0){
            p.next = lists[0];
            lists[0] = lists[0].next;
            p = p.next;
            if(lists[0] == null){
                swap(lists,0,len-1);
                len--;
            }
            minHeapfy(lists,0,len);
        }
        return head.next;
    }

    public void swap(ListNode[] lists,int i,int j){
        ListNode tmp = lists[i];
        lists[i] = lists[j];
        lists[j] = tmp;
    }

    public void buildMinHeap(ListNode[] lists){
        int mid = lists.length / 2 - 1;
        for(int i=mid;i>=0;i--){
            minHeapfy(lists,i,lists.length);
        }
    }

    public void minHeapfy(ListNode[] list,int index ,int size){
        int min = index,left = 2 * index + 1,right = 2 * index + 2;
        if(left < size){
            if(list[left].val < list[min].val){
                min = left;
            }
        }
        if(right < size){
            if(list[right].val < list[min].val){
                min = right;
            }
        }
        if(index != min){
            swap(list,index,min);
            minHeapfy(list,min,size);
        }
    }


}
