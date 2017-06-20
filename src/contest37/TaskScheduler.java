package contest37;

/**
 * @author boyang.lby
 * @date 6/18/17
 * @description
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Input: tasks = ['A','A','A','B','B','B'], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.addAll(map.values());
        int ret = 0;
        while(!priorityQueue.isEmpty()){
            int tmp = 0;
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<n+1;i++){
                if(!priorityQueue.isEmpty()){
                    tmp ++;
                    list.add(priorityQueue.poll());
                }
            }
            for(Integer a : list){
                if(--a != 0 ){
                    priorityQueue.offer(a);
                }
            }
            if(!priorityQueue.isEmpty()){
                ret += n + 1;
            }else{
                ret += tmp;
            }

        }

        return ret;
    }

    public static void main(String[]args){
        new TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'},2);
    }
}
