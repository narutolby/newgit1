import java.util.LinkedList;

/**
 * @author boyang.lby
 * @date 4/16/17
 * @description
 */
public class OptimalDivision {

    class Node{
        float val;
        String str;
        Node next = null;
        public Node(){
        }
        public Node(float val){
            this.val = val;
            this.str = String.valueOf((int)val);
        }
    }

    public String optimalDivision(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        Node head = new Node();
        Node p = head;
        for(int i=1;i<nums.length;i++){
            p.next = new Node(nums[i]);
            p = p.next;
        }
        return String.valueOf(nums[0]) + "/" + optimal(head).str;

    }

    public Node optimal(Node head){
        Node p = head.next;
        if(p.next == null){
            return p;
        }
        Node maxNode = null;
        float maxNum = Float.MIN_VALUE;
        while(p.next != null){
            float max = (p.val * p.next.val)/((p.val/p.next.val));
            if(max > maxNum){
                maxNum = max;
                maxNode = p;
            }
            p = p.next;
        }
        Node node = new Node(maxNode.val/maxNode.next.val);
        if(maxNode.str.indexOf("(") != -1){
           maxNode.str = maxNode.str.replace("(","").replace(")","");
        }
        node.str = "(" + maxNode.str + "/" + maxNode.next.str + ")";
        maxNode.val = node.val;
        maxNode.str = node.str;
        maxNode.next = maxNode.next.next;
        return optimal(head);
    }

    public static void main(String[]args){
        int[]nums = new int[]{100,100,10,2};
        System.out.println(new OptimalDivision().optimalDivision(nums));
    }
}
