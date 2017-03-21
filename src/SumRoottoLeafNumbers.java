/**
 * @author boyang.lby
 * @date 3/21/17
 * @description
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sumNumbers = 0;
        int currentNumbers = 0;
        if(root == null){
            return 0;
        }
        return preOrder(root,currentNumbers,sumNumbers);
    }

    public int preOrder(TreeNode root,int currentNumbers ,int sumNumbers){
        currentNumbers = currentNumbers * 10 + root.val;
        if(isLeaf(root)){
            return currentNumbers + sumNumbers;
        }
        if(root.left != null){
            sumNumbers = preOrder(root.left,currentNumbers,sumNumbers);
        }
        if(root.right != null){
            sumNumbers = preOrder(root.right,currentNumbers,sumNumbers);
        }
        return sumNumbers;
    }

    public boolean isLeaf(TreeNode node){
        if(node != null && node.left == null && node.right == null){
            return true;
        }
        return false;
    }
}
