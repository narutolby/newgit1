import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author boyang.lby
 * @date 9/9/17
 * @description
 */
public class CourseScheduleII2 {
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
        int[][]adj = new int[numCourses][numCourses];

        int[]ind = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> list = null;
            int p = prerequisites[i][1],c = prerequisites[i][0];
            adj[p][c] = 1;
            ind[c]++;
        }

        int[]mark = new int[numCourses];
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i=0;i<ind.length;i++){
            if(ind[i] == 0){
                dfs(adj,mark,i,linkedList);
            }
        }
        for(int i=0;i<mark.length;i++){
            if(mark[i] != 2) return new int[0];
        }
        for(int i=0;i<linkedList.size();i++){
            ret[i] = linkedList.get(i);
        }
        return ret;
    }

    public boolean dfs(int[][]m,int[]mark,int i,LinkedList<Integer> list){
        mark[i] = 1;
        boolean ret = false;
        for(int j = 0;j<m[i].length;j++){
            if(m[i][j] != 0) {
                if(mark[j] == 0){
                    ret = dfs(m,mark,j,list);
                    if(ret == false) return ret;
                }else if(mark[j] == 1){
                    return false;
                }else{
                    continue;
                }
            }
        }
        mark[i] = 2;
        list.addFirst(i);
        return true;
    }
}
