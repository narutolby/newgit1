import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author boyang.lby
 * @date 9/23/17
 * @description
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Map<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        dfs(node,cloneNode(node),map);
        return map.get(node.label);

    }
    public void dfs(UndirectedGraphNode node,UndirectedGraphNode cnode,Map<Integer,UndirectedGraphNode>map){
        if(map.containsKey(node.label)){
            return;
        }
        map.put(node.label,cnode);
        for(UndirectedGraphNode n : node.neighbors){
            UndirectedGraphNode newNode = map.containsKey(n.label) ? map.get(n.label) : cloneNode(n);
            map.get(node.label).neighbors.add(newNode);
            dfs(n,newNode,map);
        }
    }

    public UndirectedGraphNode cloneNode(UndirectedGraphNode node){
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        return newNode;
    }
    class UndirectedGraphNode {
             int label;
             List<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
         };
}
