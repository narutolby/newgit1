package contest99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contest29.TreeNode;

/**
 * @author boyang.lby
 * @date 8/26/18
 * @description
 */
public class J894 {
    public List<TreeNode> allPossibleFBT(int N) {
        if(N == 0){
            return Collections.emptyList();
        }
        Map<Integer,List<TreeNode>> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(0));
        map.put(1,list);
        for(int i=2;i<=N;i++){
            List<TreeNode> tList = map.getOrDefault(i,new ArrayList<>());
            map.put(i,tList);
            for(int j=1;j<=i;j++){
                if(!map.containsKey(j-1) || !map.containsKey(i-j)){
                    continue;
                }
                List<TreeNode> leftList = map.get(j-1);
                List<TreeNode> rightList = map.get(i-j);
                for(TreeNode left:leftList){
                    for(TreeNode right:rightList){
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right= right;
                        tList.add(root);
                    }
                }
            }
        }
        return map.getOrDefault(N,Collections.EMPTY_LIST);
    }

    public static void main(String[]args){
        new J894().allPossibleFBT(7);
    }
}
