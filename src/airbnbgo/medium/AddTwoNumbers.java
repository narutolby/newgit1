package airbnbgo.medium;

/**
 * @author boyang.lby
 * @date 11/10/19
 * @description
 *
 */
/**
 * Definition for singly-linked list.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class AddTwoNumbers {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode listNode = new ListNode(-1);
            ListNode result = listNode;
            while(l1 != null && l2 != null){
                ListNode newListNode = new ListNode((l1.val + l2.val + carry)%10);
                carry = (l1.val + l2.val + carry) / 10;

                listNode.next = newListNode;
                listNode = listNode.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1 != null){
                ListNode newListNode = new ListNode((l1.val + carry)%10);
                carry = (l1.val + carry) / 10;
                listNode.next = newListNode;
                l1 = l1.next;
                listNode = listNode.next;
            }
            while(l2 != null){
                ListNode newListNode = new ListNode((l2.val + carry)%10);
                carry = (l2.val + carry) / 10;
                listNode.next = newListNode;
                l2 = l2.next;
                listNode = listNode.next;
            }
            if (carry != 0){
                listNode.next = new ListNode(carry);
            }
            return result.next;
        }

    }
