package indeed.three;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author boyang.lby
 * @date 5/27/17
 * @description
 */
public class BinaryTree {
    static class Node{
        public Node(int val){
            this.value = val;
        }
        int value;
        Node left;
        Node right;
    }
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Node[] nodes = new Node[N];
        for(int i=0;i<N;i++){
            nodes[i] = new Node(i+1);
        }
        for(int i=0;i<N;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            if(l != 0){
                nodes[i].left = nodes[l-1];
            }
            if(r != 0){
                nodes[i].right = nodes[r-1];
            }
        }
        dfs(nodes[0],new Stack<String>(),K);
    }

    public static void dfs(Node node,Stack<String> stack,int k){
        if(node == null){
            return;
        }
        if(node.value == k){
            for(int i=0;i<stack.size();i++){
                System.out.print(stack.get(i));
            }
            return;
        }
        stack.push("L");
        dfs(node.left,stack,k);
        stack.pop();
        stack.push("R");
        dfs(node.right,stack,k);
        stack.pop();
    }
}
