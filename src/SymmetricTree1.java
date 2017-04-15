import java.util.LinkedList;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 4/15/17
 * @description
 */
public class SymmetricTree1 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null)return true;
        if(t1 == null && t2 != null || t2 == null && t1 != null || t2.val != t1.val) return false;
        Queue<TreeNode> queueLeft = new LinkedList<>();
        Queue<TreeNode> queueRight = new LinkedList<>();
        queueLeft.offer(t1);
        queueRight.offer(t2);
        int leveLumLeft = 0;
        int leveLumRight = 0;
        while(true){
            if(queueLeft.isEmpty() && queueRight.isEmpty()){
                return true;
            }
            leveLumLeft = queueLeft.size();
            leveLumRight = queueRight.size();
        }
    }
}
