import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author boyang.lby
 * @date 7/31/17
 * @description
 */
public class SerializeandDeserializeBinaryTree {
    public static final String Null = "NN";
    public static final String Spliter = ",";
    public String serialize(TreeNode root) {
        if(root == null){
            return Null;
        }
        StringBuilder sb = new StringBuilder();
        return buildString(root,sb);

    }

    public String buildString(TreeNode root,StringBuilder sb){
        if(root == null) {
            sb.append(Null).append(Spliter);
        }else{
            sb.append(root.val).append(Spliter);
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(Null)){
            return null;
        }
        Deque<String> deque = new LinkedList<String>();
        deque.addAll(Arrays.asList(data.split(Spliter)));
        return buildTree(deque);
    }
    public TreeNode buildTree(Deque<String> deque){
        String val = deque.remove();
        if(val.equals(Null)){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(val));
        treeNode.left = buildTree(deque);
        treeNode.right = buildTree(deque);
        return treeNode;
    }
}
