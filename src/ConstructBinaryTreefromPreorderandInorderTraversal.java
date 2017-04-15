import java.util.Arrays;

/**
 * @author boyang.lby
 * @date 4/15/17
 * @description
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        int rootIndex = selectRootIndex(inorder,preorder);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildTree(copy(preorder,1,rootIndex+1),copy(inorder,0,rootIndex));
        root.right = buildTree(copy(preorder,rootIndex+1,preorder.length),copy(inorder,rootIndex+1,inorder.length));
        return root;
    }

    public int[]copy(int[]order,int from,int to){
        if(to<from) return null;
        return Arrays.copyOfRange(order, from, to);
    }

    public int selectRootIndex(int[]inorder,int[]preorder){
        int root = preorder[0];
        int i = 0;
        while(inorder[i]!=root){
            i++;
        }
        return i;
    }
}
