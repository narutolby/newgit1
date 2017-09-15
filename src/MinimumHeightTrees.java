import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author boyang.lby
 * @date 9/9/17
 * @description
 */
public class MinimumHeightTrees {
    List<Integer> ret = new ArrayList<Integer>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 0 || edges == null || edges.length == 0){
            return Collections.EMPTY_LIST;
        }
        int[][]adj = new int[n][n];
        int[]mark = new int[n];
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]][edges[i][i]] = 1;
            adj[edges[i][1]][edges[i][0]] = 1;
        }

        return null;
    }
}
