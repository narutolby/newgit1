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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> retList = new ArrayList<TreeNode>();
        Map<String,TreeNode> map = new HashMap<String,TreeNode>();
        Set<String> set = new HashSet<String>();
        help(root,map,retList,set);
        return retList;
    }

    public String help(TreeNode node,Map<String,TreeNode> map,List<TreeNode> list,Set<String> set){
        if(node == null){
            return "NN" + ",";
        }
        String serilization = node.val + "," + help(node.left,map,list,set) + help(node.right,map,list,set);
        if(map.containsKey(serilization) && !set.contains(serilization)){
            list.add(node);
            set.add(serilization);
        }else{
            map.put(serilization,node);
        }
        return serilization;
    }
}
