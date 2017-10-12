package google.usefullquestion;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Solution1:
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode dummy=head;
        ListNode p=l1,q=l2;
        int sum=0;
        while(p!=null||q!=null){
            if(p!=null){
                sum+=p.val;
                p=p.next;
            }
            if(q!=null){
                sum+=q.val;
                q=q.next;
            }
            dummy.next=new ListNode(sum%10);
            sum/=10;
            dummy=dummy.next;
        }
        if(sum==1){
            dummy.next=new ListNode(1);
        }
        return head.next;
    }
}
//Solution2:
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            int v1= l1==null ? 0:l1.val;
            int v2= l2==null ? 0:l2.val;
            int sum=carry+v1+v2;
            carry=sum/10;
            dummy.next=new ListNode(sum%10);
            dummy=dummy.next;
            l1= l1==null?l1:l1.next;
            l2= l2==null?l2:l2.next;
        }
        return cur.next;
    }
}

/*
心得：链表的步骤：
1，首先考虑的是临界条件；
2，需要增加dummy吗？增加的dummy后的想法：
    ~dummy作为最终结果，那么需要一个currency的节点跟着dummy，这时原链表就可以直接用head走就行
    ~dummy不作为最终结果，这个题dummy都是作为最终结果的，以后讨论不作为最终结果的。
3，因为两个链表可能长度不一，分类讨论情况：
    ~在两个链表都不空的情况
    ~一个链表不为空，另一个待定(先讨论这种情况)
    ~两个链表同时结束，结果大于10
4，注意：dummy走的时候，两个l1和l2也要一起走
5，第二种方法与第一种对比：
    ~if不为空，可以用正则表达式代替，唯一注意是if中有几个语句，就必须有几个正则
相似：这题相似的都不是链表的，以后总结。
*/