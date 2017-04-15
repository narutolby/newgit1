import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 4/15/17
 * @description
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        int rootIndex = selectRootIndex(inorder,postorder);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildTree(copy(inorder,0,rootIndex),copy(postorder,0,rootIndex));
        root.right = buildTree(copy(inorder,rootIndex+1,inorder.length),copy(postorder,rootIndex,postorder.length-1));
        return root;
    }

    public int[]copy(int[]order,int from,int to){
        if(to<from) return null;
        return Arrays.copyOfRange(order, from, to);
    }

    public int selectRootIndex(int[]inorder,int[]postorder){
        int root = postorder[postorder.length-1];
        int i = 0;
        while(inorder[i]!=root){
            i++;
        }
        return i;
    }
}
