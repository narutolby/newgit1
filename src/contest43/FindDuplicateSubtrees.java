package contest43;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 7/30/17
 * @description
 */
public class FindDuplicateSubtrees {
    Map<Long, TreeNode> map = new HashMap<Long,TreeNode>();
    List<TreeNode> retList = new ArrayList<TreeNode>();
    Set<Long> set = new HashSet<Long>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return retList;
        }
        hash(root);
        return retList;
    }


    public Long hash(TreeNode root){
        if(root == null){
            return -99L;
        }
        Long hashcode = root.val + hash(root.left)*13  + hash(root.right) * 34;
        if(map.containsKey(hashcode) && !set.contains(hashcode)){
            if(root.val == map.get(hashcode).val){
                retList.add(root);
                set.add(hashcode);
            }
        }else{
            map.put(hashcode,root);
        }
        return hashcode + 1;
    }
}
