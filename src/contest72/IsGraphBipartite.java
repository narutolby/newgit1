package contest72;

/**
 * @author boyang.lby
 * @date 2/18/18
 * @description
 */
public class IsGraphBipartite {
    boolean ret = true;
    public boolean isBipartite(int[][] graph) {
        int[]table = new int[graph.length];
        for(int j=0;j<table.length;j++){
            if(table[j] == 0){
                dfs(graph,j,table,1);
            }
        }
        return ret;
    }
    public boolean dfs(int[][]graph,int i,int[]table,int mark){
        table[i] = mark;
        int[]adj = graph[i];
        for(int j=0;j<adj.length;j++){
            if(table[adj[j]] == mark){
                ret = false;
                return false;
            }else if(table[adj[j]] == 0){
                if(!dfs(graph,adj[j],table,0-mark)){
                    return false;
                }
            }
        }
        return true;
    }
}
