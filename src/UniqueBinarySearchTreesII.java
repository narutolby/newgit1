import java.util.ArrayList;
import java.util.List;

/**
 * @author boyang.lby
 * @date 5/7/17
 * @description
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return gen(1,n);
    }
    List<TreeNode> gen(int s,int e){
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if(s>e){
            ret.add(null);
            return ret;
        }
        for(int i=s;i<=e;i++){
            List<TreeNode>left = gen(s,i-1);
            List<TreeNode> right = gen(i+1,e);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
