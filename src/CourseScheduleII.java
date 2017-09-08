import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null ){
            return new int[0];
        }
        int[]ret = new int[numCourses];
        if(prerequisites.length == 0){
            for(int i=0;i<numCourses;i++){
                ret[i] = i;
            }
            return ret;
        }
        List<Integer>[]adj = new List[numCourses];

        int[]ind = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> list = null;
            int p = prerequisites[i][1],c = prerequisites[i][0];
            if(adj[p] == null){
                list = new ArrayList<Integer>();
                adj[p] = list;
            }else{
                list = adj[p];
            }
            list.add(c);
            ind[c]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(ind[i] == 0){
                queue.offer(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int pop = queue.poll();
            ret[index++] = pop;
            if(adj[pop] == null) continue;
            for(int m : adj[pop]){
                if((--ind[m]) == 0){
                    queue.offer(m);
                }
            }

        }
        if(index != numCourses) return new int[0];
        else return ret;

    }
}
