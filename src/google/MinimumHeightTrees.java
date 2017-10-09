package google;

import java.util.*;

/**
 * 310
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]



 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]

 Note:

 (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

 (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> retList = new ArrayList<Integer>();
        int[]table = new int[n];
        Set<Integer> set = new HashSet<Integer>();
        for(int i =0;i<n;i++){
            set.add(i);
        }
        Map<Integer,List<Integer>>adj = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            table[edges[i][0]]++;
            table[edges[i][1]]++;
            adj.put(edges[i][0],adj.getOrDefault(edges[i][0],new ArrayList<>()));
            adj.put(edges[i][1],adj.getOrDefault(edges[i][1],new ArrayList<>()));
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        while(set.size() > 2){
            List<Integer> tmpList = new ArrayList<Integer>();
            for(int i = 0;i<table.length;i++){
                if(table[i] == 1){
                    tmpList.add(i);
                }
            }
            for(int i : tmpList){
                set.remove(i);
                table[i]--;
                for(int j : adj.get(i)){
                        table[j]--;
                }
            }
        }
        retList.addAll(set);
        return retList;
    }
    public static void main(String[]args){
        new MinimumHeightTrees().findMinHeightTrees(8,new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {0, 4}, {4, 5},{4,6},{6,7}
        });
    }
}
