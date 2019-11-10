package bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 7/27/19
 * @description
 * 题目详情
标题：服务循环依赖检测
描述信息
在微服务的架构下，公司内部会有非常多的独立服务。

服务之间可以相互调用，往往大型应用调用链条很长，如果出现循环依赖将出现非常恶劣的影响。

对于一个具体应用，已知各个服务的调用关系（即依赖关系），请判断是否存在循环调用。

输入：

一组服务依赖关系list，('A', 'B') 表示 A 会调用 B 服务

service_relations = [('A', 'B'), ('A', 'C'), ('B', 'D'), ('D', 'A')]

输出：

由于存在 A - B - D - A 故存在循环依赖，返回True；反之如果不存在，返回False

Follow up：

1. 如果有多个环，请都检测出来

2. 返回每个环中的服务名

参考答案
可以采用拓扑排序 或者 DFS思路解决

评分标准
3.0 思路正确，代码无重大bug

3+ 思路快，写的快，bugfree

3.5 follow up的问题都能处理的很好
 */
public class TopologicalSort {
    static class Graph{
        private Map<Integer,List<Integer>> adj = new HashMap<Integer,List<Integer>>();
        private Map<Integer,Integer> indegree = new HashMap<Integer,Integer>();

        public void AddEdege(int a, int b){
            List<Integer> adjList = adj.getOrDefault(a,new LinkedList<Integer>());
            adjList.add(b);
            indegree.put(b,indegree.getOrDefault(b,0) + 1);
        }
    }


    public void toplogicalSort(Graph graph){
        Queue<Integer> queue = new LinkedList<Integer>();
        for (Map.Entry<Integer,Integer> entry:graph.indegree.entrySet()){
            if (entry.getValue() == 0){
                queue.offer(entry.getValue());
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            result.add(vertex);
            for (Integer adjVertex : graph.adj.get(vertex)){
                graph.indegree.put(adjVertex,graph.indegree.get(adjVertex)-1);
                if (graph.indegree.get(adjVertex) == 0){
                    queue.offer(adjVertex);
                }
            }
        }
    }

}
