package contest99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author boyang.lby
 * @date 8/26/18
 * @description
 */
public class FreqStack {
    private int no = 0;
    private Map<Integer, Stack<ListNode>> map = new HashMap<>();
    private TreeMap<Integer, Set<Integer>> treeMap = new TreeMap<>();
    private ListNode headNode, p = new ListNode(-1, -1);

    class ListNode {
        int v;
        ListNode pre, next;
        int no;
        public ListNode(int v, int no) {
            this.v = v;
            this.no = no;
        }
    }

    public FreqStack() {

    }

    public void push(int x) {
        ListNode node = new ListNode(x, ++no);
        p.next = node;
        node.pre = p;
        p = node;
        Stack<ListNode> stack = map.getOrDefault(x, new Stack<>());
        map.put(x, stack);
        stack.push(node);
        Set<Integer> set = treeMap.getOrDefault(stack.size()-1,new HashSet<Integer>());
        treeMap.put(stack.size()-1,set);
        set.remove(x);
        if(set.isEmpty()){
            treeMap.remove(stack.size()-1);
        }
        Set<Integer> set1 = treeMap.getOrDefault(stack.size(),new HashSet<Integer>());
        treeMap.put(stack.size(), set1);
        set1.add(x);
    }

    public int pop() {
        Set<Integer> set = treeMap.lastEntry().getValue();
        int last = 0;
        Stack<ListNode> max = null;
        for(Integer v : set){
            Stack<ListNode> stack = map.get(v);
            ListNode node = stack.peek();
            if(node == null){
                continue;
            }
            if(node.no >=last){
                last = node.no;
                max = stack;
            }
        }
        if(max == null){
            return -1;
        }
        ListNode maxNode = max.pop();
        maxNode.pre.next = maxNode.next;
        if(maxNode.next != null){
            maxNode.next.pre = maxNode.pre;
        }
        Set<Integer> set1 = treeMap.get(max.size()+1);
        set1.remove(maxNode.v);
        if(set1.size() == 0){
            treeMap.remove(max.size()+1);
        }
        Set<Integer> set2 = treeMap.getOrDefault(max.size(),new HashSet<Integer>());
        set2.add(maxNode.v);
        treeMap.put(max.size(), set2);
        if(p == maxNode){
            this.p = maxNode.pre;
        }
        return maxNode.v;
    }

    public static void main(String[]args){
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
