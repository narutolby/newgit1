package bytedance;

/**
 * @author boyang.lby
 * @date 7/27/19
 * @description
 * 标题：判断单向链表是否有环
描述信息
判断一个链表中是否有环

例如：A->B->C->D->B->C->D

D指向B形成环

要求：在空间复杂度O(1)的情况下，时间复杂度最小

参考答案
创建两个指针slow，fast，同时指向这个链表的头节点。

然后让两个指针开始循环移动

slow每次向下移动一个节点，fast每次向下移动两个节点，然后比较两个指针指向的节点是否相同。如果相同，则判断出链表有环，如果不同，则继续下一次循环

评分标准
2.5分及以下：无思路，或者代码完不成
3.0分：思路代码ok，无大问题
3+分：边界处理得当，bugfree
评论与参考
暂无评论
 */

public class NoCycleLink {

    static class LinkNode extends Object{
        int value;
        LinkNode next;

        @Override
        public boolean equals(Object node){
            if (this == node){
                return true;
            }
            if (this.value == ((LinkNode)node).value){
                return true;
            }
            return false;
        }
    }


    boolean hasCycle(LinkNode head){
        if (head == null){
            return Boolean.FALSE;
        }
        LinkNode fast = head, slow = head;
        while(slow.next != null && fast.next != null){
            if (slow == fast){
                return true;
            }
        }
        return Boolean.FALSE;
    }

}
